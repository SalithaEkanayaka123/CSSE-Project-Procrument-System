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
    public void AddOrder(Order order); /** Taneesha **/ /** wait -- need to check later**/
    public void deleteOrder (); /** Akash **/ /** ok
     * @param order**/
    public void updateOder (Order order, Long id); /** Akash **/ /** ok **/

    /** User **/
    public double calculateTotalCostForSupplier(Supplier supplierId); /** wait **/ /** wait **/

    /** Item **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/ /** wait **/ /** wait **/
    public List<Item> getOrderItemListByStatus(String status, String supplierId); /** Salitha - done (Test failing but sql data comming)**//** wait **/


    /** deliveryNotice **/
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject); /** Akash - done - working**//** wait **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ /** wait **/ //State (final | intermediate).


    /**payment**/
    public void processPayment(String order); /** Akash **//** wait **/



    // New Util Method for Payment Process.
    public List<Item> getAdviceNoticeItemList(String orderId); /**  ? - Difficulty Level - High **/
    public int writeReturnValues(List<Item> returnItems, String supplierId); /**  ? - Difficulty Level - Low **/










}
