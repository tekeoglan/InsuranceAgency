package com.tekeoglan.insuranceagency;

import java.util.Date;

public class HealthInsurence extends Insurance {

    public HealthInsurence(Date startTime, Date dueTime, double priceRate) {
        this.startTime = startTime;
        this.dueTime = dueTime;
        this.price = 2000;
        this.name = "Health Insurence";
        this.priceRate = priceRate;
    }

    @Override
    public double calculate() {
        return this.price * this.priceRate;
    }
}
