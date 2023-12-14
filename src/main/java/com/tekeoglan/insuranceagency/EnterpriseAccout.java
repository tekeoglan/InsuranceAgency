package com.tekeoglan.insuranceagency;

import java.util.ArrayList;

public class EnterpriseAccout extends Account {
    public EnterpriseAccout(User user) {
        this.user = user;
        this.authStatus = AuthanticationStatus.FAIL;
        this.insurances = new ArrayList<>();
    }

    @Override
    public void addInsurence(Insurance insurance) {
        this.insurances.add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return this.user.firstName.compareTo(o.user.firstName);
    }
}
