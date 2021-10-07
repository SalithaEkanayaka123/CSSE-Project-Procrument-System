package lk.csse.procurement.backend.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "deliveryadvice")
public class DeliveryAdvice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "deliveryID")
    private int deliveryID;

    @Column(name = "address")
    private String address;

    @Column(name = "ltemList")
    private ArrayList<Item> ltemList;

    @Column(name = "note")
    private String note;

    @Column (name="stage")
    private String stage;

    @Column(name = "orderID")
    private String orderID;

    public DeliveryAdvice(int deliveryID, String address, ArrayList<Item> ltemList, String note, String orderID) {
        this.deliveryID = deliveryID;
        this.address = address;
        this.ltemList = ltemList;
        this.note = note;
        this.orderID = orderID;
    }

    public DeliveryAdvice() {

    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Item> getLtemList() {
        return ltemList;
    }

    public void setLtemList(ArrayList<Item>  ltemList) {
        this.ltemList = ltemList;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
