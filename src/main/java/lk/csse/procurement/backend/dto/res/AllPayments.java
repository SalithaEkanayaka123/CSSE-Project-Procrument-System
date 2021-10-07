package lk.csse.procurement.backend.dto.res;


import java.util.Date;

public class AllPayments {
    private int paymentid;
    private double amount;
    private Date date;
    private String description;
    private String invoice_no;
    private String card_no;
    private Date exp_date;
    private String holder_name;
    private String check_no;
    private String dtype;

    public AllPayments () {

    }

    public AllPayments(int tid, double amount, Date date, String description, String invoice_no, String card_no, Date exp_date, String holder_name, String check_no) {
        this.paymentid = tid;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.invoice_no = invoice_no;
        this.card_no = card_no;
        this.exp_date = exp_date;
        this.holder_name = holder_name;
        this.check_no = check_no;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }

    public String getCheck_no() {
        return check_no;
    }

    public void setCheck_no(String check_no) {
        this.check_no = check_no;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
