package lk.csse.procurement.backend.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


public class AcceptedDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "accountNo")
    private int orderId;
    @Column(name = "accountNo")
    private int siteManagerId;
    @Column(name = "accountNo")
    private Date acceptDate;
    @Column(name = "accountNo")
    private int deliveryId;

    public AcceptedDelivery(int orderId, int siteManagerId, Date acceptDate, int deliveryId) {
        this.orderId = orderId;
        this.siteManagerId = siteManagerId;
        this.acceptDate = acceptDate;
        this.deliveryId = deliveryId;
    }

    public AcceptedDelivery() {

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSiteManagerId() {
        return siteManagerId;
    }

    public void setSiteManagerId(int siteManagerId) {
        this.siteManagerId = siteManagerId;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}
