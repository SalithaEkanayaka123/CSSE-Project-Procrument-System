package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.*;

import java.util.List;
import java.util.Optional;

public interface ProcumentRepository {

    /** JPA method to store orders **/
    public Order addOrder(Order order);

    /** Clean the mapper record when order items are deleted **/
    public int cleanOrderItemTable(Order order);

    /** Insert Order Items to the Mapper table - This mapper table will be used to create JOIN queries **/
    int insertOrderItems(int orderId, Item orderItemList) ;

    /** Query to get all order details from order table **/
    public Order getAllOrderDetails(Order order);

    /** Query to get all suppliers **/
    public List<Supplier> getAllAvailableSuppliers();

    /** Query to update the approval state of Orders **/
    public int updateOrderApprovalStatus(String orderId, String approvalState);

    /** Query get all items **/
    public List<Item> getOrderItemList(String orderId);

    /** Query Get Item by Id **/
    public List<Item> getItemByID(int item_id);

    /** Query to filter suppliers by orders **/
    public List<Supplier> getSuppliersByOrder(String orderID);

    /** Query to insert delivery advice **/
    public int saveTheDeliveryAdivce(AcceptedDelivery acceptedDelivery);

    /** Query to filter order items by status **/
    public List<Item> getOrderItemListByStatus(String supplierID, String status);

    /** Query to get the Delivery Status - (Old comparison method) Replaced with Array comparison method **/
    public String getDeliveryStatus(String orderId);

    /** Query to filter the delivery items by order Id **/
    public List<Item> getDeliveryItemsForOrder(String orderId);
    public List<Item> getOrderItemListBySupplierID(String supplierId);

    /**
     * JPA Removing | Replacement Methods. | Update Methods.
     * **/
    public List<User> selectUser(int id);
    public List<Order> selectOrder(String id);
    public List<Item> selectItem(int id);

    /**
     * JPA Removing | Replacement Methods. | Delete Methods.
     * **/
    public int deleteUser(String userId);
    public int deleteOrder(String orderId);
    public int deleteItem(int itemId);

    /**
     * JPA Removing | Replacement Methods. | Cleanup Method.
     * **/
    public int cleanUPOrderItemTable(String orderId);
}
