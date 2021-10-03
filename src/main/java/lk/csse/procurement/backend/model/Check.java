package lk.csse.procurement.backend.model;
import javax.persistence.*;

@Entity
@Table(name = "check" ,schema="csse")
public class Check extends Payment {

    @Column(name = "checkNo")
    private int checkNo;

    public Check() {

    }

    public Check(int checkNo) {
        this.checkNo = checkNo;
    }

    public int getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(int checkNo) {
        this.checkNo = checkNo;
    }
}
