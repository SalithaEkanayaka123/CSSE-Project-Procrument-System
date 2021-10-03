package lk.csse.procurement.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private String invoiceNo;
    private String orderID;
    private String paymentStatus;
    private Date date;
    private ArrayList<Item> itemList;
    @Column(name = "amount")
    private double amount;

    public Invoice(String invoiceNo, String orderID, String paymentStatus, Date date, ArrayList<Item> itemList, double amount) {
        this.invoiceNo = invoiceNo;
        this.orderID = orderID;
        this.paymentStatus = paymentStatus;
        this.date = date;
        this.itemList = itemList;
        this.amount = amount;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
