package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface OrderService {

    /** JPA Methods to Insert Data to the Table **/
    public void test();
    public void createUser();
    public void AddItems();

    /** Getting a Item list based on the orderId **/
    public List<Item> getItemListByItemID(int itemID);

    /** Check the availability status of each supplier and getting a list. **/
    public List<Supplier> RequestAvailableSuppliers(String availability);

    /** Getting a list of supplier by order Id **/
    public List<Supplier>  getSuppliersByOrder(String orderId);

    /** Getting a order item list by order Id **/
    public List<Item> getOrderItemList(String orderId);

    /** Method for Manager to approve the order (Applicable only for orders more than 100,000/=) **/
    public int orderManagerApproval(String orderId, String value );

    /** Calculate the total cost for one order by Id **/
    public double calculateTotalCostForOrder(String orderId);

    /** Add order method using JPA **/
    public void AddOrder(Order order);//done

    /** Delete order using the order Id **/
    public void deleteOrder ();

    /** Update the order content using order Id **/
    public void updateOder (Order order, String id);

    /** Update the order content using order Id **/
    public Item updateItem (Item item, int id);

    /** Update the user content using user Id **/
    public User updateUser (User user, String id);


    /** Calculate the total cost for each supplier **/
    public double calculateTotalCostForSupplier(String supplierId);

    /** Add return Items **/
    public Item addReturnItems(ArrayList<Item> list);

    /** Getting a Item list based on the orderId **/
    public List<Item> getOrderItemListByStatus(String status, String supplierId);

    /** This method is to compare the items in product order and delivery advice **/
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject);

    /** Accept the delivery Advice Notice and saved in the database **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject);  //State (final | intermediate).

    /** This method process the payment using the item validate methods defined above **/
    public void processPayment(String order);

    /** Fetch the list of items included in the Delivery Advice notice **/
    public List<Item> getAdviceNoticeItemList(String orderId);

    /** This method process the payment using the item validate methods defined above **/
    public int writeReturnValues(List<Item> returnItems, String supplierId);

    public List<Item> getOrderItemListBySupplierID(String supplierId);

    /**
     * JPA Replacement Service Methods.
     * Navigate to the repository class.
     * **/


}
