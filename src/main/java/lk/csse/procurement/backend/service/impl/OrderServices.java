package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.*;
import lk.csse.procurement.backend.repository.ItemRepository;
import lk.csse.procurement.backend.repository.OrderRepository;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import lk.csse.procurement.backend.repository.UserRepository;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    OrderService orderService;



    @Override
    public void test() {
        System.out.println("Done");
    }

    @Override
    public void createUser() {
        Supplier supplier = new Supplier("4", "Salitha", "Ekanayaka", "salitha@gmail.com", "", "", "supplier");
        supplier.setAvailability(true);
        userRepository.save(supplier);
    }

    @Override
    public void AddItems() {
        Item item = new Item();
        item.setItemId(3);
        item.setItemName("item2");
        item.setDescription("description3");
        item.setPrice(1000);
        item.setQty(5);
        itemRepository.save(item);

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
            System.out.println("itemlist count " + itemList.size());
            if(itemList.size() > 0){

                for(Item item : itemList){
                    System.out.println(item.getQty());
                    totalCost = (double) totalCost + item.getPrice()*item.getQty();
                }


            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        return totalCost;

    }

    @Override
    public void AddOrder(Order order1) {
        Order order = new Order();
        order.setDeliveryAddress(order1.getDeliveryAddress());
        order.setDescription(order1.getDescription());
        //order.setItemList(order1.getItemList());
        order.setOrderId(order1.getOrderId());
        order.setSiteLocation(order1.getSiteLocation());
        order.setSiteManager(order1.getSiteManager());
        order.setStatus(order1.getStatus());
        order.setSupplierId(order1.getSupplierId());
        order.setTotalPrice(order1.getTotalPrice());
        order.setRequiredDate(order1.getRequiredDate());
        order.setPurchaseDate(order1.getPurchaseDate());
        orderRepository.save(order);


        //System.out.println(itemList1);
        // Iteration for adding items to the order once order is inserted.
        try {
            for (Item I : order1.getItemList()) {
                procumentRepository.insertOrderItems(Integer.parseInt(order1.getOrderId()), I);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteOrder() {
        /**
         * Process: Delete Orders
         * User: Management Staff.
         * **/
        Order order = new Order();
        order.setOrderId("1");
        orderRepository.delete(order);

        // Table Clean up method to clean  the mapping table.
        procumentRepository.cleanOrderItemTable(order);
    }

    @Override
    public void updateOder(Order order1, String id) {
        Order order = procumentRepository.selectOrder(id);
        if(order != null) {
            procumentRepository.updateOrder(order1, id);
        }else{
            order = null;
        }
        /**
         * Process: Update an Order
         * User: Management Staff.
         * **/

    }

    @Override
    public Item updateItem(Item item, int id) {
        Item items = procumentRepository.selectItem(id);
        if(items != null) {
            procumentRepository.updateItem(item, id);
        }else{
            itemRepository.save(item);
        }
        return items;
    }

    @Override
    public User updateUser(User user, String id) {
        User person = procumentRepository.selectUser(id);
        System.out.println("gg " + person);
        if(person != null) {
            System.out.println("calling");
            procumentRepository.updateUser(user, id);
        }else{
            userRepository.save(user);
        }
        return person;
    }

    @Override
    public List<Item> getItemListByItemID(int itemID) {
        return procumentRepository.getItemByID(itemID);
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
        // Filtering Logic Comes here.
        return procumentRepository.getOrderItemList(orderId);
    }

    @Override
    public int orderManagerApproval(String orderId, String value) {
        /**
         * Process: Update the Approval Status of the Order
         * User: Manager.
         * **/
//        String OrderId = orderId.getOrderId();
        int status = procumentRepository.updateOrderApprovalStatus(orderId, value);
        if(status == 1){
            System.out.println("Completed");
        } else {
            System.out.println("Error");
        }

        return status;
    }


    @Override
    public double calculateTotalCostForSupplier(String supplierId) {
        double totalCost = 0;
        try{
            List<Item> itemList = orderService.getOrderItemListBySupplierID(supplierId);
            System.out.println("itemlist count " + itemList.size());
            if(itemList.size() > 0){
                for(Item item : itemList){
                    System.out.println(item.getQty());
                    totalCost = (double) totalCost + item.getPrice()*item.getQty();
                }
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return totalCost;
    }

    @Override
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject) {
        /**
         *
         * This method compare the delivery.
         * Following logic compare the exact objects. Regardless of the values inside.
         * **/
//        System.out.println(order.equals(daobject));
//        boolean status = order.equals(daobject);
//        return status;

        int comparison_count =0;
        // Manually comparing objects inside the array list
        for (int i=0; i< order.size(); i++) {
            for(int j=0; j< daobject.size(); j++){
                if (order.get(i).getItemName().contentEquals(daobject.get(j).getItemName())) {
                    comparison_count=+1;
                }
            }
        }

        // Output the result.
        if(comparison_count == order.size()){
            return true;
        } else {
            return false;
        }
    }




    @Override
    public Item addReturnItems(ArrayList<Item> list) {

        return null;
    }

    @Override
    public void processPayment(String orderId) {
        /**
         *
         * 1. fetch item arrays from both delivered item List and Order item list.
         * 2. if the stage is final
         *
         * **/

        //validation for item quality and equality.
        // Fetch order items.
        ArrayList<Item> order_list = (ArrayList<Item>) procumentRepository.getOrderItemList(orderId);
        // Fetch Delivery Items.
        ArrayList<Item> deliver_list = (ArrayList<Item>) procumentRepository.getDeliveryItemsForOrder(orderId);
        //Calling the Array Comparison method | Check whether all the items has received in the order.
        if (compareDeliveryAdviceProductOrder(order_list, deliver_list)) {
            System.out.println("Eligible to proceed to the payment");
        } else {
            System.out.println("Not Eligible to Proceed to the payment");
        }


    }

    @Override
    public List<Item> getOrderItemListByStatus(String status, String supplierId) {
        return procumentRepository.getOrderItemListByStatus(supplierId, status);
    }

    @Override
    public List<Item> getOrderItemListBySupplierID(String supplierId) {
        return procumentRepository.getOrderItemListBySupplierID(supplierId);
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

        int status = procumentRepository.saveTheDeliveryAdivce(acceptedDelivery);
        return null;
    }

    @Override
    public List<Item> getAdviceNoticeItemList(String orderId) {
        return procumentRepository.getOrderItemList(orderId);
    }

    @Override
    public int writeReturnValues(List<Item> returnItems, String supplierId, String orderId) {
        try{
            for(Item item : returnItems){
                procumentRepository.returnItems(String.valueOf(item.getItemId()), item.getItemName(), supplierId, orderId);
            }
        } catch (Exception e){
            System.out.println("Error inserting return items");
            return -1;
        }
        return 0;
    }


}
