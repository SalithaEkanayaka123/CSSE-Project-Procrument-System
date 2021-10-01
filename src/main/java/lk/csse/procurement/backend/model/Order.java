package lk.csse.procurement.backend.model;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    @Column(name = "orderId")
    private String orderId;

    @Column(name = "siteLocation")
    private String siteLocation;

    @Column(name = "siteManager")
    private String siteManager;

    @Column(name = "itemList")
    private ArrayList<Item> itemList;

    @Column(name = "purchaseDate")
    private Date purchaseDate;

    @Column(name = "requiredDate")
    private Date requiredDate;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @Column(name = "description")
    private String description;

    @Column(name = "totalPrice")
    private float totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "suplierID")
    private String supplierId;

    public Order() {

    }

    public Order(String orderId, String siteLocation, ArrayList<Item> itemList, Date purchaseDate, Date requiredDate, String deliveryAddress, String description, float totalPrice, String status, String supplierId) {
        this.orderId = orderId;
        this.siteLocation = siteLocation;
        this.itemList = itemList;
        this.purchaseDate = purchaseDate;
        this.requiredDate = requiredDate;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.totalPrice = totalPrice;
        this.status = status;
        this.supplierId = supplierId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
