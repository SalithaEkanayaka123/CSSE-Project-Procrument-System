package lk.csse.procurement.backend.model;
import javax.persistence.*;
import java.util.Date;

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentID;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "invoiceNo")
    private String invoiceNo; /////////////////5 













}
