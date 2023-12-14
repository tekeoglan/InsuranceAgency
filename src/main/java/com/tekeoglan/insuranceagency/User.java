package com.tekeoglan.insuranceagency;

import java.util.ArrayList;
import java.util.Date;

public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String job;
    int age;

    ArrayList<Address> addresses;
    Date lastLoginTime;

    public User(
            String firstName,
            String lastName,
            String email,
            String password,
            String job,
            int age
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.addresses = new ArrayList<>();
    }
}
