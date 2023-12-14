package com.tekeoglan.insuranceagency;

public class HomeAddress implements Address {
    private String address;

    HomeAddress(String address) {
        this.address = address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
