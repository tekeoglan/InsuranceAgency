package com.tekeoglan.insuranceagency;

import java.util.Date;

public class TravelInsurance extends Insurance {
    public TravelInsurance(Date startTime, Date dueTime, double priceRate) {
        this.startTime = startTime;
        this.dueTime = dueTime;
        this.price = 1000;
        this.name = "Travel Insurence";
        this.priceRate = priceRate;
    }

    @Override
    public double calculate() {
        return this.price * this.priceRate;
    }
}
