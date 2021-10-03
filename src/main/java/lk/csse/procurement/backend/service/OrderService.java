package lk.csse.procurement.backend.service;

import lk.csse.procurement.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

public interface OrderService {

    public void test();
    public void AddOrder ();
    public ArrayList<Supplier> RequestAvailableSuppliers(String availability);
    public void getSuppliersByOrder(Order orderId);
    public void getOrderItemList(int orderId);
    public boolean orderManagerApproval(Order orderId, boolean value );
    public void calculateTotalCostForOrder( int orderId);
    public double calculateTotalCostForSupplier(Supplier supplierId);
    public double calculateTotalCostForOrder(Order orderItem);
    public boolean compareDeliveryAdviceProductOrder(Order order, DeliveryAdvice daobject);
    public Item addReturnItems(ArrayList<Item> list);
    public void processPayment(Order order);
    public String getOrderItemListByStatus(boolean status, int supplierId);
    public String acceptDeliveryAdviceNotice(int orderid, SiteManager Id, Date acceptDate, DeliveryAdvice daobject, String stage); //State (final | intermediate).








}
