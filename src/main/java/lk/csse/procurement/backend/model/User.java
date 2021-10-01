package lk.csse.procurement.backend.model;

import javax.persistence.Column;

public class User {

    @Column(name = "userID")
    private String userID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;
}
