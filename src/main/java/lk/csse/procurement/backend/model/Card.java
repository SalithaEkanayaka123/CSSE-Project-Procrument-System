package lk.csse.procurement.backend.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "card")
public class Card extends Payment {

    @Column(name = "cardNo")
    private int cardNo;
    @Column(name = "expDate")
    private Date expDate;
    @Column(name = "holderName")
    private String holderName;

    public Card(int cardNo) {
        this.cardNo = cardNo;
    }

    public Card() {

    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }


}
