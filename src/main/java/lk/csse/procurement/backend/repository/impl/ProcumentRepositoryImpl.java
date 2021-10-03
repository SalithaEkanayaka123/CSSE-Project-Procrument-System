package lk.csse.procurement.backend.repository.impl;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProcumentRepositoryImpl implements ProcumentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Order addOrder(Order order) {

        /**
        Date dateObj = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateObj);
        cal.add(Calendar.DAY_OF_YEAR, 0);
        Map<String, Object> params = new HashMap<>();

        String query = "INSERT INTO noc_vw_user_role(user_name, role, created_user, created_date) " +
                "    VALUES (:user_name, :role, :created_user, :created_date)";

        params.put("user_name", );
        params.put("role", );
        params.put("created_user", );
        params.put("created_date", new Timestamp(cal.getTimeInMillis()));
        return namedParameterJdbcTemplate.update(query, params);
         **/

        return null;
    }

    @Override
    public Order getAllOrderDetails(Order order) {
        return null;
    }

    @Override
    public ArrayList<Supplier> getAllAvailableSuppliers() {
        String sql = "SELECT * FROM users WHERE availability = 'true'";
        return null;
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
        String query = "SELECT i.item_name, i.description " +
                "FROM order_items o " +
                "INNER JOIN orders ot  ON ot.order_id = o.order_id " +
                "INNER JOIN item i on o.item_id = i.item_id " +
                "WHERE ot.order_id = :orderId ";

        params.put("orderid", orderId);
        List<Item> list = namedParameterJdbcTemplate.query(query, params, (rs, i) -> getOrderItemArray(rs));
        return list != null && list.size() != 0 ? list : null;
    }

    public Item getOrderItemArray(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setItemId(Integer.parseInt(rs.getString("item_name")));
        item.setItemId(Integer.parseInt(rs.getString("description")));
        /*
        * Code should be changed to a join query and parameters should ne updated.
        * */
        return item;
    }



    /**
     *
     * PostgresSQL DB Methods.
     *
     * **/
}
