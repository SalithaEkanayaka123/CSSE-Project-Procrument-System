package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.*;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
@Service
public class OrderServices implements OrderService {

    @Autowired
    ProcumentRepository procumentRepository;


    @Override
    public void test() {
        System.out.println("Done");
    }

    @Override
    public void AddOrder() {

    }

    @Override
    public ArrayList<Supplier> RequestAvailableSuppliers(String availability) {
        return null;
    }

    @Override
    public void getSuppliersByOrder(Order orderId) {

    }

    @Override
    public void getOrderItemList(int orderId) {

    }

    @Override
    public boolean orderManagerApproval(Order orderId, boolean value) {
        return false;
    }

    @Override
    public void calculateTotalCostForOrder(int orderId) {

    }

    @Override
    public double calculateTotalCostForSupplier(Supplier supplierId) {
        return 0;
    }

    @Override
    public double calculateTotalCostForOrder(Order orderItem) {
        return 0;
    }

    @Override
    public boolean compareDeliveryAdviceProductOrder(Order order, DeliveryAdvice daobject) {
        return false;
    }

    @Override
    public Item addReturnItems(ArrayList<Item> list) {
        return null;
    }

    @Override
    public void processPayment(Order order) {

    }

    @Override
    public String getOrderItemListByStatus(boolean status, int supplierId) {
        return null;
    }

    @Override
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject, String stage) {
        return null;
    }


}
