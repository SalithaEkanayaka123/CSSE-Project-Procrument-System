package lk.csse.procurement.backend.model;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    @Column(name = "orderId")
    private String orderId;

    @Column(name = "siteLocation")
    private String siteLocation;

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

}
