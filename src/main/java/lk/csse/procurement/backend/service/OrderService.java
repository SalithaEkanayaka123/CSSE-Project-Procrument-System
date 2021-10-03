package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface OrderService {

    public void test();
    public void createUser();


    public void AddOrder (); /** Taneesha **/
    public List<Supplier> RequestAvailableSuppliers(String availability); /** OK **/
    public List<Order>  getSuppliersByOrder(String orderId); /** Salitha **/
    public void getOrderItemList(int orderId); /** Menaka **/
    public int orderManagerApproval(Order orderId, String value ); /** Akash - done **/
    public double calculateTotalCostForOrder(String orderId); /** Akash - done **/
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public boolean compareDeliveryAdviceProductOrder(ArrayList<Order> order, ArrayList<Order> daobject); /** Akash - done **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/
    public void processPayment(Order order); /** Menaka **/
    public String getOrderItemListByStatus(boolean status, int supplierId); /** Salitha **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject); /** Akash - done **/ //State (final | intermediate).








}
