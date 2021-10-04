package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.*;
import lk.csse.procurement.backend.repository.ItemRepository;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.repository.UserRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderServices implements OrderService {

    @Autowired
    ProcumentRepository procumentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public void test() {
        System.out.println("Done");
    }

    @Override
    public void createUser() {
        Supplier supplier = new Supplier("", "Salitha", "Ekanayaka", "salitha@gmail.com", "", "", "true");
        supplier.setAvailability(true);
        userRepository.save(supplier);
    }

    @Override
    public void AddItems() {
        Item item = new Item();
        item.setItemId(1);
        item.setItemName("item1");
        item.setDescription("description");
        item.setPrice(1200);
        item.setQty(5);

        itemRepository.save(item);

    }

    @Override
    public void AddOrder(List<Item> itemList) {
        Order order = new Order();
        order.setDeliveryAddress("No 6, Malabe");
        order.setDescription("This is new order");
        order.setOrderId("3");
        order.setSiteLocation("Malabe");
        order.setSiteManager("manager_1");
        order.setStatus("Approved");
        order.setSupplierId("S001");
        order.setTotalPrice(23000);
        orderRepository.save(order);

        // Iteration for adding items to the order once order is inserted.
        try {
            List<Item> OrderItems = null;
            for (Item I : OrderItems) {
                procumentRepository.insertOrderItems(Integer.parseInt(order.getOrderId()), I);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addOrderItems() {

    }

    @Override
    public void deleteOrder() {
        /**
         * Process: Delete Orders
         * User: Management Staff.
         * **/

    }

    @Override
    public void updateOder() {
        /**
         * Process: Update an Order
         * User: Management Staff.
         * **/

    }

    @Override
    public List<Supplier> RequestAvailableSuppliers(String availability) {
        List<Supplier> availableSuppliers = procumentRepository.getAllAvailableSuppliers();
        return availableSuppliers;
    }

    @Override
    public List<Supplier> getSuppliersByOrder(String orderId) {
        List<Supplier> orderlist = procumentRepository.getSuppliersByOrder(orderId);
        return  orderlist;

    }

    @Override
    public List<Item> getOrderItemList(String orderId) {
        return procumentRepository.getOrderItemList(orderId);
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
    public double calculateTotalCostForOrder(String orderId) {
        /**
         * Process: Calculate the Total Cost for Orders
         * User: Manager.
         * **/
        double totalCost = 0;
        try{
            List<Item> itemList = procumentRepository.getOrderItemList(orderId);
            if(itemList.size() > 0){
                for(Item item : itemList){
                    totalCost = totalCost + item.getPrice();
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        return totalCost;
    }

    @Override
    public double calculateTotalCostForSupplier(Supplier supplierId) {
        return 0;
    }

    @Override
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject) {
        /**
         *
         * This method compare the delivery.
         *
         * **/
        System.out.println(order.equals(daobject));
        boolean status = order.equals(daobject);
        return status;
    }




    @Override
    public Item addReturnItems(ArrayList<Item> list) {

        return null;
    }

    @Override
    public void processPayment(Order order) {

    }

    @Override
    public List<Item> getOrderItemListByStatus(String status, String supplierId) {
        return procumentRepository.getOrderItemListByStatus(supplierId, status);
    }

    @Override
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject) {
        /**
         *
         * Create a DeliveryAdvice insert method to store the daobjects in the database.
         * create a model acceptedDeliveryAdviceNotices model class and store them in the database.
         *
         * **/
        AcceptedDelivery acceptedDelivery = new AcceptedDelivery();
        acceptedDelivery.setOrderId(orderid);
        acceptedDelivery.setSiteManagerId(Integer.parseInt(Id.getUserID()));
        acceptedDelivery.setAcceptDate(acceptDate);
        acceptedDelivery.setDeliveryId(Integer.parseInt(daobject.getDeliveryID()));

        procumentRepository.saveTheDeliveryAdivce(acceptedDelivery);
        return null;
    }


}
