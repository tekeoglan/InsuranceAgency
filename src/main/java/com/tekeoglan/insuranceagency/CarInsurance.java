package com.tekeoglan.insuranceagency;

import java.util.Date;

public class CarInsurance extends Insurance {

    public CarInsurance(Date startTime, Date dueTime, double priceRate) {
        this.startTime = startTime;
        this.dueTime = dueTime;
        this.price = 300;
        this.name = "Car Insurence";
        this.priceRate = priceRate;
    }

    @Override
    public double calculate() {
        return this.price * this.priceRate;
    }
}
