package lk.csse.procurement.backend.model;

public class Supplier extends User{
    public Supplier(String userID, String firstName, String lastName, String email, String phoneNo, String password, String type) {
        super(userID, firstName, lastName, email, phoneNo, password, type);
    }
}
