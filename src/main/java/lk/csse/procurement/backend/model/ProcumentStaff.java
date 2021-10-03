package lk.csse.procurement.backend.model;


import javax.persistence.*;

@Entity
@Table(name = "procumentstaff")
public class ProcumentStaff extends User {

    public ProcumentStaff(String userID, String firstName, String lastName, String email, String phoneNo, String password, String type) {
        super(userID, firstName, lastName, email, phoneNo, password, type);
    }

    public ProcumentStaff() {

    }
}
