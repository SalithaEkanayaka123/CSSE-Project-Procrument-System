package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.model.DeliveryAdvice;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
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
//        orderServices.AddOrder();
        System.out.println("");
    }

    /**
     *
     * Anawaratne M.A.N.A. Method Testing.
     *
     * **/

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
        java.util.Date date =new java.util.Date();

        Order order = new Order();
        order.setOrderId("1");
        order.setStatus("true");
        orderServices.procumentRepository.updateOrderApprovalStatus(order.getOrderId(), "ture");
    }

    @Test
    public void TestingcalculateTotalCostForOrder(){

        double cost = orderServices.calculateTotalCostForOrder("10");
        System.out.println("Price of the Order - " + cost);
    }

    @Test
    public void TestingcompareDeliveryAdviceProductOrder() {

        //Item object to store in the array.
        Item item = new Item();
        item.setItemId(1);
        Item item2 = new Item();
        item2.setItemId(1);

        //Constructing testing Arrays.
        ArrayList<Item> orderList = new ArrayList<>();
            orderList.add(item);
        ArrayList<Item> adviceOrderList = new ArrayList<>();
            adviceOrderList.add(item2);

        boolean status = orderServices.compareDeliveryAdviceProductOrder(orderList, adviceOrderList);
        System.out.println(status);
        System.out.println();
    }

    @Test
    public void TestingprocessPayment(){
        orderServices.processPayment("2");
    }

    /**
     *
     * Anawaratne M.A.N.A. Method Testing.
     *         ||||||||||||||||
     * **/

    @Test
    public void RequestAvailableSuppliers() {
        orderServices.RequestAvailableSuppliers("true");
    }

    @Test
    public void getSuppliersByOrder() {
        orderServices.getSuppliersByOrder("3");
    }

    @Test
    public void AddItems(){
        orderServices.AddItems();
    }//

    @Test
    public void AddOrder(){
        orderServices.AddOrder(orderServices.getItemListByItemID(2));
    }

    @Test
    public void getOrderItemList(){
        orderServices.getOrderItemList("3");
    }//


    @Test
    public void getOrderItemListByStatus(){
        orderServices.getOrderItemListByStatus("S001", "Approved");
    }




}