package lk.csse.procurement.backend.repository.impl;
import lk.csse.procurement.backend.mapper.ItemMapper;
import lk.csse.procurement.backend.mapper.OrderMapper;
import lk.csse.procurement.backend.mapper.SupplierMapper;
import lk.csse.procurement.backend.model.AcceptedDelivery;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProcumentRepositoryImpl implements ProcumentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Order addOrder(Order order) {

        /**
         * Main order item get saved with JPA.
         **/

        return null;
    }

    @Override
    public int insertOrderItems(int orderId, Item orderItemList) {
        Map<String, Object> params = new HashMap<>();
        String query = "INSERT INTO order_items(order_id, item_id) " +
                "VALUES (:item_id, :order_id)";
        params.put("item_id", orderItemList.getItemId());
        params.put("order_id", orderId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public Order getAllOrderDetails(Order order) {
        return null;
    }

    @Override
    public List<Supplier> getAllAvailableSuppliers() {
        String sql = "SELECT * FROM users WHERE availability = 'true'";
        List<Supplier> sup = namedParameterJdbcTemplate.query(sql, new SupplierMapper());
        return sup;
    }

    @Override
    public int updateOrderApprovalStatus(String orderId, String approvalState) {
        Map<String, Object> params = new HashMap<>();
        String query = "UPDATE orders " +
                "SET status = :approvalstatus " +
                "WHERE order_id = :orderid";
        params.put("approvalstatus", approvalState);
        params.put("orderid", orderId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public List<Item> getOrderItemList(String orderId) {
        // Format the String into '' If error.
        Map<String, Object> params = new HashMap<>();
        //Join Query
        String query = "SELECT i.item_name, i.description, i.price " +
                "FROM order_items o " +
                "INNER JOIN orders ot  ON ot.order_id = o.order_id " +
                "INNER JOIN item i ON o.item_id = i.item_id " +
                "WHERE ot.order_id ='" + orderId + "'";
        params.put("orderid", orderId);
        List<Item> list = namedParameterJdbcTemplate.query(query, (rs, i) -> getOrderItemArray(rs));
        return list != null && list.size() != 0 ? list : null;
    }

    @Override
    public List<Supplier> getSuppliersByOrder(String orderID) {
        Object[] parameters = new Object[]{orderID};
        String sql = "SELECT * FROM orders ot INNER JOIN users u  ON u.userid = ot.suplierid WHERE u.availability = true and ot.order_id = ?";;
        return jdbcTemplate.query(sql, parameters,new SupplierMapper());//new MapSqlParameterSource()
        //new String[]{ orderID }, new OrderMapper()
    }

    @Override
    public int saveTheDeliveryAdivce(AcceptedDelivery acceptedDelivery) {
        Map<String, Object> params = new HashMap<>();
        String sql = "INSERT INTO accepted_delivery VALUES()"; //Complete the code.
        return 0;
    }

    @Override
    public List<Item> getOrderItemListByStatus(String supplierID, String status) {
        Object[] parameters = new Object[]{supplierID, status};
        String sql = "SELECT * FROM order_items o INNER JOIN orders ot  ON ot.order_id = o.order_id INNER JOIN item i on o.item_id = i.item_id WHERE ot.status = 'Approved' AND ot.suplierid = 'S001'";
        return jdbcTemplate.query(sql, parameters,new ItemMapper());
    }

    public Item getOrderItemArray(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setItemName(rs.getString("item_name"));
        item.setDescription(rs.getString("description"));
        item.setPrice(rs.getDouble("price"));
        /*
        * Code should be changed to a join query and parameters should ne updated.
        * */
        return item;
    }

    public Item addReturnItems(ResultSet order_id) {
        Map<String, Object> params = new HashMap<>();
        String query = "SELECT i.item_name, i.description\n" +
                "FROM order_items o\n" +
                "INNER JOIN orders ot ON ot.order_id = o.order_id\n" +
                "INNER JOIN item i on o.item_id = i.item_id\n" +
                "WHERE ot.order_id = 1";

        List<Item> list = namedParameterJdbcTemplate.query(query, params, (rs, i) -> addReturnItems(rs));
        return list != null && list.size() != 0 ? (Item) list : null;
    }

    /**
     *
     * PostgresSQL DB Methods.
     *
     * **/
}
