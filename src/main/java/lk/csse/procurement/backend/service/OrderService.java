package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface OrderService {

    public void test();
    public void createUser();
    public void AddItems();

    public List<Item> getItemListByItemID(int itemID);/** Salitha **/ /** done **/
    public List<Supplier> RequestAvailableSuppliers(String availability); /** OK **/ /** done **/
    public List<Supplier>  getSuppliersByOrder(String orderId); /** Done **/ /** done **/
    public List<Item> getOrderItemList(String orderId); /** Done  **/  /** done **/
    public int orderManagerApproval(String orderId, String value ); /** Akash - done - working **/ /** done **/

    /** Order **/
    public double calculateTotalCostForOrder(String orderId); /** Akash - done - working **/ /** done **/




    /** User **/


    /** Item **/

    public List<Item> getOrderItemListByStatus(String status, String supplierId); /** done **//** done **/
    public List<Item> getOrderItemListBySupplierID(String supplierId);


    /** deliveryNotice **/
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject); /** Akash - done - working**//** wait **/



    /**payment**/
    public double calculateTotalCostForSupplier(String supplierId); /** done **/ /** done **/




    // New Util Method for Payment Process.
    public List<Item> getAdviceNoticeItemList(String orderId); /**  ? - Difficulty Level - High **/ /**  done **/


    /**
     * JPA Replacement Service Methods.
     * Navigate to the repository class.
     *
     * **/






    /** need to done **/
    public void AddOrder(Order order); /** Taneesha **/ /** wait -- need to check later**/
    public void deleteOrder (); /** Akash **/ /** ok
     * @param order**/

    public void updateOder (Order order, Long id); /** Akash **/ /** ok **/

    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/ /** wait  check latter **/ /** wait **/
    public int writeReturnValues(List<Item> returnItems, String supplierId); /**  ? - Difficulty Level - Low **/
    public void processPayment(String order); /** Akash **//** wait **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ /** wait **/ //State (final | intermediate).








}
