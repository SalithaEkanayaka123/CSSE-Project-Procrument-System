package lk.csse.procurement.backend.service.impl;
import lk.csse.procurement.backend.dto.res.AllPayments;
import lk.csse.procurement.backend.model.Item;
import lk.csse.procurement.backend.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServicesTest {

    @Autowired
    OrderServices orderServices;



    /**
     *
     * Anawaratne M.A.N.A. Method Testing.
     *
     * **/

    /**
     * Testing method for adding users
     */
    @Test
    public void TestingCreateUser() {

        orderServices.createUser();
    }

    /**
     * Testing method for changing the status of order
     */

    @Test
    public void TestingCourseApprovalmethod() {
        orderServices.procumentRepository.updateOrderApprovalStatus("7", "pending");
    }

    /**
     * Testing method for calculating total cost
     */

    @Test
    public void TestingcalculateTotalCostForOrder(){
        double cost = orderServices.calculateTotalCostForOrder("7");
        System.out.println("Price of the Order - " + cost);
    }

    @Test
    public void calculateTotalCostForSupplier(){

        double cost = orderServices.calculateTotalCostForSupplier("1");
        System.out.println("Price of the Order - " + cost);
    }

    @Test
    public void TestingcompareDeliveryAdviceProductOrder() {

        //Item object to store in the array.
        Item item = new Item();
        item.setItemName("Kamal");
        Item item2 = new Item();
        item2.setItemName("Kamal");

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
        orderServices.processPayment("6");
    }


    @Test
    public void TestingwriteReturnValues() {
        ArrayList<Item> orderList = new ArrayList<>();
        Item item = new Item();
        item.setItemName("Kamal");
        item.setItemId(1);
        Item item2 = new Item();
        item2.setItemName("Bimal");
        item2.setItemId(3);

        orderList.add(item);
        orderList.add(item2);

        orderServices.writeReturnValues(orderList, "1", "2");
    }


    @Test
    public void TestinggetAllPayment() {
        List<AllPayments> list = orderServices.getAllPayment();
        for(AllPayments payments : list){
            System.out.println(payments.getDescription());
        }
    }

    /**
     *
     * Anawaratne M.A.N.A. Method Testing.
     *     ||||||||||||||||
     *
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
    public void getOrderItemList(){
        orderServices.getOrderItemList("3");
    }


    @Test
    public void getOrderItemListByStatus(){
        orderServices.getOrderItemListByStatus("S001", "Approved");
    }

    /**
     *
     * Ekanayaka E.M.S.G.
     *     ||||||||||||||||
     *
     * **/

    /**
     * Testing method for adding orders
     */
    @Test
    public void TestingAddOrder() {
        // Add Order
        Order order1 = new Order();
        order1.setOrderId("1000");
        order1.setDescription("description 1");
        order1.setSupplierId("2");
        order1.setTotalPrice(23000);
        orderServices.AddOrder(order1);
    }

    /**
     * Testing method for get Order Item List
     */

    @Test
    public void TestingGetOrderItemList() {
        orderServices.getOrderItemList("1");
    }

    /**
    *
    * Chandrasena T.K.T.A
    *     ||||||||||||||||
    *
    * **/
    @Test
    public void TestingGetItemListByID() {
        orderServices. getItemListByItemID(3);
    }


    @Test
    public void AddItems(){
        orderServices.AddItems();
    }

}