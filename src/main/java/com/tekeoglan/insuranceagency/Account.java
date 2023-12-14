package com.tekeoglan.insuranceagency;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account> {
    protected User user;
    protected AuthanticationStatus authStatus;
    protected ArrayList<Insurance> insurances;

    public void login(String email, String password) throws InvalidAuthanticationException {
        if (!this.user.email.equals(email) || !this.user.password.equals(password)) {
            throw new InvalidAuthanticationException();
        }
        this.authStatus = AuthanticationStatus.SUCCESS;
    }

    public AuthanticationStatus getAuthStatus() {
        return this.authStatus;
    }

    public void addAddress(Address address) {
        this.user.addresses.add(address);
    }

    public void removeAddress(Address address) {
        this.user.addresses.remove(address);
    }

    public User getUser() {
        return this.user;
    }

    public abstract void addInsurence(Insurance insurance);

    protected final void showUserInfo() {
        System.out.printf("Name: %s %s\n", this.user.firstName, this.user.lastName);
        System.out.printf("Email: %s\n", this.user.email);
        System.out.printf("Age: %d\n", this.user.age);
        System.out.printf("Job: %s\n", this.user.job);
        System.out.println("Addresses:");
        for (Address address : this.getUser().addresses) {
            System.out.println("----------------------------------");
            System.out.printf("- Address: %s\n", address.getAddress());
            System.out.println("----------------------------------");
        }
        System.out.println("Insurances:");
        for (Insurance insurance : this.insurances) {
            System.out.println("----------------------------------");
            System.out.printf("Name: %s\n", insurance.name);
            System.out.printf("Price: %s\n", insurance.calculate());
            System.out.printf("Start: %s\n", insurance.startTime);
            System.out.printf("Due: %s\n", insurance.dueTime);
            System.out.println("----------------------------------");
        }
    }
}
