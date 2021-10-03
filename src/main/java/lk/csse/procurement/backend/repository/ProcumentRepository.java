package lk.csse.procurement.backend.repository;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface ProcumentRepository {

    public Order addOrder(Order order);
    public Order getAllOrderDetails(Order order);
    public ArrayList<Supplier> getAllAvailableSuppliers();
    public int updateOrderApprovalStatus(String orderId, String approvalState);
    public List<Item> getOrderItemList(String orderId);

}
