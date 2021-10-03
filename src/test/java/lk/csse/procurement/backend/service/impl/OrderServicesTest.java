package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import lk.csse.procurement.backend.service.OrderService;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServicesTest {

    @Autowired
    OrderServices orderServices;

    @Test
    public void TestingAddOrder() {
        orderServices.AddOrder();
        System.out.println("");
    }

    @Test
    public void TestingCreateUser() {
        orderServices.createUser();
    }

    @Test
    public void TestingCourseApprovalmethod() {

        Item item1 = new Item();
        Item item2 = new Item();

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        java.util.Date date=new java.util.Date();


        Order order = new Order();
        order.setOrderId("12");
        order.setStatus("true");
        orderServices.procumentRepository.updateOrderApprovalStatus(order.getOrderId(), "ture");
    }

    @Test
    public void RequestAvailableSuppliers() {
        orderServices.RequestAvailableSuppliers("false");
    }





}