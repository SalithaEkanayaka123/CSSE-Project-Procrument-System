package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

public interface OrderService {

    public void test();
    public void createUser();


    public void AddOrder (); /** Taneesha **/
    public ArrayList<Supplier> RequestAvailableSuppliers(String availability); /** Salitha **/
    public void getSuppliersByOrder(Order orderId); /** Salitha **/
    public void getOrderItemList(int orderId); /** Menaka **/
    public int orderManagerApproval(Order orderId, String value ); /** Akash - done **/
    public void calculateTotalCostForOrder( int orderId); /** Taneesha **/
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public double calculateTotalCostForOrder(Order orderItem); /** Akash **/
    public boolean compareDeliveryAdviceProductOrder(Order order, DeliveryAdvice daobject); /** Akash **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/
    public void processPayment(Order order); /** Menaka **/
    public String getOrderItemListByStatus(boolean status, int supplierId); /** Salitha **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject, String stage); /** Akash **/ //State (final | intermediate).








}
