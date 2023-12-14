package com.tekeoglan.insuranceagency;

import java.util.Date;

public class ResidenceInsurance extends Insurance {
    public ResidenceInsurance(Date startTime, Date dueTime, double priceRate) {
        this.startTime = startTime;
        this.dueTime = dueTime;
        this.price = 30000;
        this.name = "Residence Insurence";
        this.priceRate = priceRate;
    }

    @Override
    public double calculate() {
        return this.price * this.priceRate;
    }
}
