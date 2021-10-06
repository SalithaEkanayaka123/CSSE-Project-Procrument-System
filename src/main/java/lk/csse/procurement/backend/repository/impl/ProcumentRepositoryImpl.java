package lk.csse.procurement.backend.repository.impl;
import lk.csse.procurement.backend.mapper.ItemMapper;
import lk.csse.procurement.backend.mapper.OrderMapper;
import lk.csse.procurement.backend.mapper.SupplierMapper;
import lk.csse.procurement.backend.mapper.UserMapper;
import lk.csse.procurement.backend.model.*;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
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
    public int cleanOrderItemTable(Order order) {
        Map<String, Object> params = new HashMap<>();
        String query = "DELETE FROM order_items WHERE order_id = (:username)";
        params.put("username", order.getOrderId());
        return namedParameterJdbcTemplate.update(query, params);
    }


    @Override
    public int insertOrderItems(int orderId, Item orderItemList) {
        System.out.println("ssssaa " + orderItemList);
        Map<String, Object> params = new HashMap<>();
        String query = "INSERT INTO order_items(order_id, item_id) " +
                "VALUES (:order_id, :item_id)";
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
        String sql = "SELECT * FROM users WHERE availability = 'true' and type = 'supplier'";
        List<Supplier> sup = namedParameterJdbcTemplate.query(sql, new SupplierMapper());
        return sup;
    }

    @Override
    public List<User> getAllSiteManagers() {
        String sql = "SELECT * FROM users WHERE type = 'Site Manager'";
        List<User> sup = namedParameterJdbcTemplate.query(sql, new UserMapper());
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
        String query = "SELECT i.item_name, i.description, i.price , i.qty " +
                "FROM order_items o " +
                "INNER JOIN orders ot  ON ot.order_id = o.order_id " +
                "INNER JOIN item i ON o.item_id = i.item_id " +
                "WHERE ot.order_id ='" + orderId + "'";
        params.put("orderid", orderId);
        List<Item> list = namedParameterJdbcTemplate.query(query, (rs, i) -> getOrderItemArray(rs));
        return list != null && list.size() != 0 ? list : null;
    }

    @Override
    public List<Item> getItemByID(int item_id) {
        Object[] parameters = new Object[]{item_id};
        String sql = "SELECT * from item where item_id = ?";
        List<Item> sup = jdbcTemplate.query(sql, parameters, new ItemMapper());
        return sup;
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
        String sql = "INSERT INTO accepted_delivery VALUES()"; //Complete the code.
        return 0;
    }

    @Override
    public List<Item> getOrderItemListByStatus(String supplierID, String status) {
        Object[] parameters = new Object[]{status, supplierID};
        String sql = "SELECT * FROM order_items o INNER JOIN orders ot  ON ot.order_id = o.order_id INNER JOIN item i on o.item_id = i.item_id WHERE ot.status = ? AND ot.suplierid = ?";
        return jdbcTemplate.query(sql, parameters,new ItemMapper());
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        String sql = "SELECT d.stage " +
                "FROM deliveryadvice d " +
                "WHERE d.orderid ='" + orderId + "'";
        Map<String, Object> params = new HashMap<>();
        params.put("order_id", orderId);
        try {
            String type = namedParameterJdbcTemplate.queryForObject(
                    sql, params, String.class);
            return type;
        } catch (Exception e) {
            return "Error";
        }
    }

    @Override
    public List<Item> getDeliveryItemsForOrder(String orderId) {
        Map<String, Object> params = new HashMap<>();
        String sql = "SELECT i.item_name, i.description, i.price, i.qty " +
                "FROM item_delivery_advice a " +
                "INNER JOIN item i  ON i.item_id = a.item_id " +
                "INNER JOIN deliveryadvice d ON d.deliveryid = a.delivery_advice_id " +
                "WHERE d.orderid ='" + orderId + "'";
        params.put("order_id", orderId);
        List<Item> list = namedParameterJdbcTemplate.query(sql, (rs, i) -> getOrderItemArray(rs));
        return list != null && list.size() != 0 ? list : null;
    }

    @Override
    public List<Item> getOrderItemListBySupplierID(String supplierId) {
        Object[] parameters = new Object[]{supplierId};
        String sql = "SELECT * FROM order_items o INNER JOIN orders ot  ON ot.order_id = o.order_id INNER JOIN item i ON o.item_id = i.item_id WHERE ot.suplierid = ?";
        return jdbcTemplate.query(sql, parameters,new ItemMapper());
    }

    public Item getOrderItemArray(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setItemName(rs.getString("item_name"));
        item.setDescription(rs.getString("description"));
        item.setPrice(rs.getDouble("price"));
        item.setQty(rs.getInt("qty"));
        return item;
    }

    /**
     * No need of use this both object are same, can use one mapper class
     * **/
    public Item getDeliveryItemArray(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setItemName(rs.getString("item_name"));
        item.setDescription(rs.getString("description"));
        item.setPrice(rs.getDouble("price"));
        return item;
    }

    public Item addReturnItems(ResultSet order_id) {
        Map<String, Object> params = new HashMap<>();
        String query = "SELECT i.item_name, i.description\n" +
                "FROM order_items o\n" +
                "INNER JOIN orders ot ON ot.order_id = o.order_id\n" +
                "INNER JOIN item i on o.item_id = i.item_id\n" +
                "WHERE ot.order_id ='" + 2 + "'";

        List<Item> list = namedParameterJdbcTemplate.query(query, params, (rs, i) -> addReturnItems(rs));
        return list != null && list.size() != 0 ? (Item) list : null;
    }

    /**
     *
     * JPA Replacement Methods.
     *
     *
     * @param id**/

    @Override
    public User selectUser(String id) {
        try{
            Object[] parameters = new Object[]{id};
            String sql = "select * from users where userid = ?";
            User user = jdbcTemplate.queryForObject(sql, parameters,new UserMapper());
            return user;
        }catch (IncorrectResultSizeDataAccessException e){
            System.out.println("calling inc " + e);
            return  null;
        } catch (Exception e){
            System.out.println(e);
            return  null;
        }
    }

    @Override
    public void updateUser(User user, String id) {
        Map<String, Object> params = new HashMap<>();//DELETE FROM users WHERE userid = '4'
        String query = "UPDATE users SET email = (:email), first_name = (:first_name), last_name = (:last_name), password = (:password) , phone_no = (:phone_no) , type = (:type) WHERE userid = (:user_id)";
        params.put("email", user.getEmail());
        params.put("first_name", user.getFirstName());
        params.put("last_name", user.getLastName());
        params.put("password", user.getPassword());
        params.put("phone_no", user.getPhoneNo());
        params.put("type", user.getType());
        params.put("user_id", id);
        namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public void updateOrder(Order order, String id) {
        Map<String, Object> params = new HashMap<>();//DELETE FROM users WHERE userid = '4'
        String query = "UPDATE orders SET delivery_address = '(:email)', description = '(:first_name)', purchase_date = '(:last_name)', required_date = '(:password)' , site_location = '(:phone_no)' , site_manager = '(:type)', status = '(:status)', suplierid = '(:suplierid)', total_price = '(:total_price)'  WHERE order_id =  (:user_id)";
        params.put("email", order.getDeliveryAddress());
        params.put("first_name", order.getDescription());
        params.put("last_name", order.getPurchaseDate());
        params.put("password", order.getRequiredDate());
        params.put("phone_no", order.getSiteLocation());
        params.put("status", order.getStatus());
        params.put("suplierid", order.getSupplierId());
        params.put("total_price", order.getTotalPrice());
        params.put("type", order.getSiteManager());
        params.put("user_id", id);
        namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public void updateItem(Item item, int id) {
        Map<String, Object> params = new HashMap<>();//DELETE FROM users WHERE userid = '4'
        String query = "UPDATE item SET description = '(:email)', item_name = '(:first_name)', qty = '(:last_name)', price = '(:password)' WHERE item_id =  (:user_id)";
        params.put("email", item.getDescription());
        params.put("first_name", item.getItemName());
        params.put("last_name", item.getQty());
        params.put("password", item.getPrice());
        params.put("user_id", id);
        namedParameterJdbcTemplate.update(query, params);
    }

    //    jdbcTemplateObject.queryForObject(
//    SQL, new Object[]{id}, new StudentMapper());
    @Override
    public Order selectOrder(String id) {
        try{
            Object[] parameters = new Object[]{id};
            String sql = "select * from orders where order_id = ?";
            Order res = jdbcTemplate.queryForObject(sql, parameters,new OrderMapper());
            return res ;
        }catch (IncorrectResultSizeDataAccessException e){
            return  null;
        } catch (Exception e){
            System.out.println(e);
            return  null;
        }

    }

    @Override
    public Item selectItem(int id) {
        try{
            Object[] parameters = new Object[]{id};
            String sql = "select * from item where item_id = ?";
            Item res = jdbcTemplate.queryForObject(sql, parameters,new ItemMapper());
            return res;
        }catch (IncorrectResultSizeDataAccessException e){
            return  null;
        } catch (Exception e){
            System.out.println(e);
            return  null;
        }

    }

    @Override
    public int deleteUser(String userId) {
        Map<String, Object> params = new HashMap<>();//DELETE FROM users WHERE userid = '4'
        String query = "DELETE FROM users WHERE userid = (:user_id)";
        params.put("user_id", userId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int deleteOrder(String orderId) {
        Map<String, Object> params = new HashMap<>();
        String query = "DELETE FROM orders WHERE order_id = (:order_id)";
        params.put("order_id", orderId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int deleteItem(int itemId) {
        Map<String, Object> params = new HashMap<>();//DELETE FROM item WHERE item_id = 1
        String query = "DELETE FROM item WHERE item_id = (:item_id)";
        params.put("item_id", itemId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int cleanUPOrderItemTable(String orderId) {
        Map<String, Object> params = new HashMap<>();
        String query = "DELETE FROM order_items WHERE order_id = (:order_id)";
        params.put("order_id", orderId);
        return namedParameterJdbcTemplate.update(query, params);
    }

    @Override
    public int returnItems(String ItemId, String ItemName, String supplierId, String orderId) {
        // Format String
        String itemName = "'" + ItemName + "'";
        Map<String, Object> params = new HashMap<>();
        try{
            String query = "INSERT INTO return_items (item_id, item_name,supplier_id, order_id) " +
                    "VALUES (1, '2', 2, 4)";
            params.put("item_id", Integer.parseInt(ItemId));
            params.put("item_name", itemName);
            params.put("supplier_id", Integer.parseInt(supplierId));
            params.put("order_id", Integer.parseInt(ItemId));
            return namedParameterJdbcTemplate.update(query, params);
        } catch (Exception e){
            System.out.println("Error Parsing String Values into Integers");
        }
        return 0;
    }


    /**
     *
     * PostgresSQL DB Methods.
     *
     * **/
}
