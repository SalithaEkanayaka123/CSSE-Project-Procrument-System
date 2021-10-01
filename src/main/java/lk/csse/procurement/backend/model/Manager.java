package lk.csse.procurement.backend.model;
import javax.persistence.*;

public class Manager extends User{

    public Manager(String userID, String firstName, String lastName, String email, String phoneNo, String password, String type) {
        super(userID, firstName, lastName, email, phoneNo, password, type);
    }
}
