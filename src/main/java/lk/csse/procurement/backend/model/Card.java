package lk.csse.procurement.backend.model;

import java.util.Date;

public class Card {
    private int cardNo;
    private Date expDate;
    private String holderName;//////3

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
