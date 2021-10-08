package lk.csse.procurement.backend.repository.impl;

import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.repository.ProcumentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProcumentRepositoryImplTest {

    @Autowired
    ProcumentRepository procumentRepository;

    @Test
    public void TestingInsertOrderItems(){
        Item item = new Item();
        item.setItemId(4);
        procumentRepository.insertOrderItems(1, item);
    }

    @Test
    public void TestinggetOrderItemArray() {
        List<Item> orderItemList = procumentRepository.getOrderItemList("1");
        for (Item order: orderItemList){
            System.out.println(order.getDescription());
        }
    }

    @Test
    public void TestinggetDeliveryStatus() {
        String orderId = "3";
        String status = procumentRepository.getDeliveryStatus(orderId);
        System.out.println(status);
    }

    @Test
    public void TestinggetDeliveryItemsForOrder(){
        String orderId = "2";
        List<Item> deliveryItems = procumentRepository.getDeliveryItemsForOrder(orderId);
        for(Item I : deliveryItems){
            System.out.println(I.getDescription());
        }
    }

    @Test
    public void TestingreturnItems(){
        procumentRepository.returnItems("1","Nameless Item","3", "4");
    }



    /**
     * Testing method for Ekanayaka E.M.S.G
     */

    @Test
    public void TestinggetOrdersForSupplier(){
        procumentRepository.getOrdersForSupplier("2");
    }

    @Test
    public void TestingdeleteOrder(){
        procumentRepository.deleteOrder("999");
    }


    /**
     * Testing method for Chandrasena T.K.T.A
     */

    @Test
    public void TestingdeleteItem(){
        procumentRepository.deleteItem(3);
    }



}