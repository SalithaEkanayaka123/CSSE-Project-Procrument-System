package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;

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
    public double calculateTotalCostForOrder(String orderId); /** Akash - done - working **/ /** wait **/
    public void AddOrder(List<Item> itemList); /** Taneesha **/ /** wait **/
    public void deleteOrder (); /** Akash **/ /** wait **/
    public void updateOder (); /** Akash **/ /** wait **/

    /** User **/
    public double calculateTotalCostForSupplier(Supplier supplierId); /** wait **/ /** wait **/

    /** Item **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/ /** wait **/ /** wait **/
    public List<Item> getOrderItemListByStatus(String status, String supplierId); /** Salitha - done (Test failing but sql data comming)**//** wait **/


    /** deliveryNotice **/
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject); /** Akash - done - working**//** wait **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ /** wait **/ //State (final | intermediate).


    /**payment**/
    public void processPayment(Order order); /** Akash **//** wait **/














}
