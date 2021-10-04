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


    public void AddOrder(List<Item> itemList); /** Taneesha **/
    public void deleteOrder (); /** Akash **/
    public void updateOder (); /** Akash **/

    public List<Supplier> RequestAvailableSuppliers(String availability); /** OK **/ /** added to Controller **/
    public List<Supplier>  getSuppliersByOrder(String orderId); /** Done **/
    public List<Item> getOrderItemList(String orderId); /** Menaka - Done check error comming when testing - salitha **/
    public int orderManagerApproval(Order orderId, String value ); /** Akash - done - working **/
    public double calculateTotalCostForOrder(String orderId); /** Akash - done - working **/
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Item> order, ArrayList<Item> daobject); /** Akash - done - working**/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/
    public void processPayment(String orderId); /** Akash **/
    public List<Item> getOrderItemListByStatus(String status, String supplierId); /** Salitha - done (Test failing but sql data comming)**/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ //State (final | intermediate).

    // New Util Method for Payment Process.
    public List<Item> getAdviceNoticeItemList(String orderId); /**  ? - Difficulty Level - High **/
    public int writeReturnValues(List<Item> returnItems, String supplierId); /**  ? - Difficulty Level - Low **/










}
