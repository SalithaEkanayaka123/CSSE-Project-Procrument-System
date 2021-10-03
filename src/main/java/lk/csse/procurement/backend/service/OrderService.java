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
    public void getSuppliersByOrder(Order orderId); /** Salitha **/
    public void getOrderItemList(int orderId); /** Menaka **/
    public int orderManagerApproval(Order orderId, String value ); /** Akash - done **/
    public void calculateTotalCostForOrder( int orderId); /** Taneesha **/
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public double calculateTotalCostForOrder(Order orderItem); /** Akash - done **/
    public boolean compareDeliveryAdviceProductOrder(Order order, DeliveryAdvice daobject); /** Akash **/
    public Item addReturnItems(ArrayList<Item> list); /** Taneesha **/
    public void processPayment(Order order); /** Menaka **/
    public String getOrderItemListByStatus(boolean status, int supplierId); /** Salitha **/
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject, String stage); /** Akash **/ //State (final | intermediate).








}
