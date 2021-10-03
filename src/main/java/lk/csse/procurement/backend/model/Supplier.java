package lk.csse.procurement.backend.model;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;


@Entity
@Table(name = "supplier")
public class Supplier extends User{

    @Column(name = "availability")
    private boolean availability;

    public Supplier(String userID, String firstName, String lastName, String email, String phoneNo, String password, String type) {
        super(userID, firstName, lastName, email, phoneNo, password, type);
    }

    public Supplier() {

    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
