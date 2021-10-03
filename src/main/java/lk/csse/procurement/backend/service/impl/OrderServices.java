package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.*;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.repository.UserRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
@Service
public class OrderServices implements OrderService {

    @Autowired
    ProcumentRepository procumentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void test() {
        System.out.println("Done");
    }

    @Override
    public void createUser() {
        User supplier = new Supplier();
        supplier.setLastName("Ekanayaka");
        supplier.setFirstName("Salitha");
        userRepository.save(supplier);
    }

    @Override
    public void AddOrder() {
        Order order = new Order();
        order.setDeliveryAddress("No 6, Malabe");
        order.setDescription("This is new order");
//        order.setItemList();
        order.setOrderId("O112");
//      order.setPurchaseDate("2021.10.03");
//        order.setRequiredDate();
        order.setSiteLocation("Malabe");
        order.setSiteManager("manager_1");
        order.setStatus("Approved");
        order.setSupplierId("S001");
        order.setTotalPrice(23000);
        orderRepository.save(order);


    }

    @Override
    public ArrayList<Supplier> RequestAvailableSuppliers(String availability) {
        ArrayList<Supplier> availableSuppliers = procumentRepository.getAllAvailableSuppliers();
        return availableSuppliers;
    }

    @Override
    public void getSuppliersByOrder(Order orderId) {

    }

    @Override
    public void getOrderItemList(int orderId) {

    }

    @Override
    public int orderManagerApproval(Order orderId, String value) {
        /**
         * Process: Update the Approval Status of the Order
         * User: Manager.
         * **/
        String OrderId = orderId.getOrderId();
        int status = procumentRepository.updateOrderApprovalStatus(OrderId, value);
        if(status == 1){
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }

        return status;
    }

    @Override
    public void calculateTotalCostForOrder(int orderId) {
        /**
         * Process: Calculate the Total Cost for Orders
         * User: Manager.
         * **/


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
