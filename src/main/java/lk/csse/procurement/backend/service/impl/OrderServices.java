package lk.csse.procurement.backend.service.impl;

import lk.csse.procurement.backend.model.Account;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderServices implements OrderService {

    /**
     * Place Order method.
     * **/
    public Order createOrder(ArrayList<Item> itemList,
                             String siteLocation,
                             String siteManager,
                             Date requiredDate,
                             String deliveryAddress,
                             String description){

        Order order = new Order();
        order.setItemList(itemList);
        order.setSiteLocation(siteManager);
        order.setRequiredDate(requiredDate);
        order.setDeliveryAddress(deliveryAddress);
        order.setDescription(description);
        order.setSiteLocation(siteLocation);
        return order;
    }

    /**
     * View Purchase Order
     * **/
    public Order viewOrder(String orderId){
       // Get Order Item from the Repository.
        return null;
    }

    /**
     * Account Service Methods.
     * **/

    public Account getAccounts(){
        // Get Order Item from the Repository.
        return null;
    }
    public Account AddAccountDetails(int UserId){

        Account account  = new Account();
        // Call the DB method.
        return null;
    }

    public Account getAccount(int userId){

        // Call the DB method.
        return null;
    }

    /**
     * Supplier and Item List
     * **/

    public ArrayList<Item> getItems(){
        // Get Order Item from the Repository.
        return null;
    }
    public Item AddItem(int UserId){

        Item account  = new Item(); // Item inheritance Use a pattern
        // Call the DB method.
        return null;
    }

    public Item getItem(int itemId){
        // Call the DB method.
        return null;
    }



}
