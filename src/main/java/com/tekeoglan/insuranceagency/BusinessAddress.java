package com.tekeoglan.insuranceagency;

public class BusinessAddress implements Address {
    private String address;

    public BusinessAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
