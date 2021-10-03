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


    public void AddOrder (); /** Taneesha **/
    public List<Supplier> RequestAvailableSuppliers(String availability); /** OK **/
    public List<Supplier>  getSuppliersByOrder(String orderId); /** Done **/
    public List<Item> getOrderItemList(String orderId); /** Menaka - Done check error comming when testing - salitha **/
    public int orderManagerApproval(Order orderId, String value ); /** Akash - done **/
    public double calculateTotalCostForOrder(String orderId); /** Akash - done **/
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Order> order, ArrayList<Order> daobject); /** Akash - done **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/
    public void processPayment(Order order); /** Menaka **/
    public List<Item> getOrderItemListByStatus(String status, String supplierId); /** Salitha - done (Test failing but sql data comming)**/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ //State (final | intermediate).








}
