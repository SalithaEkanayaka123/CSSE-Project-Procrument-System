package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.AcceptedDelivery;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;

import java.util.List;

public interface ProcumentRepository {

    public Order addOrder(Order order);
    public int cleanOrderItemTable(Order order);
    int insertOrderItems(int orderId, Item orderItemList) ;
    public Order getAllOrderDetails(Order order);
    public List<Supplier> getAllAvailableSuppliers();
    public int updateOrderApprovalStatus(String orderId, String approvalState);
    public List<Item> getOrderItemList(String orderId);
    public List<Item> getItemByID(int item_id);
    public List<Supplier> getSuppliersByOrder(String orderID);
    public int saveTheDeliveryAdivce(AcceptedDelivery acceptedDelivery);
    public List<Item> getOrderItemListByStatus(String supplierID, String status);
    public String getDeliveryStatus(String orderId); // Useless, Status should be determine by comparing two arrays.
    public List<Item> getDeliveryItemsForOrder(String orderId);
    public List<Item> getOrderItemListBySupplierID(String supplierId);

    /**
     * JPA Removing | Replacement Methods. | Update Methods.
     * **/
    public int updateUser();
    public int updateOrder();
    public int updateItem();

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
