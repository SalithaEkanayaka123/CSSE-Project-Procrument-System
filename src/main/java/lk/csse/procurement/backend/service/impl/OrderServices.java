package lk.csse.procurement.backend.service.impl;

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

}
