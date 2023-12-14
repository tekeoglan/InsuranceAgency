package com.tekeoglan.insuranceagency;

import java.util.Date;

public abstract class Insurance {
    static double ENTERPRISE_RATE = 2.5;
    static double INDIVIDUAL_RATE = 1;
    protected String name;
    protected double price;
    protected Date startTime;
    protected Date dueTime;

    protected double priceRate;

    public abstract double calculate();
}
