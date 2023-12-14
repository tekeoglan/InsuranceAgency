package com.tekeoglan.insuranceagency;

import java.util.ArrayList;

public class AddressManager {
    static void addAdress(ArrayList<Address> addresses, Address address) {
        addresses.add(address);
    }

    static void removeAddress(ArrayList<Address> addresses, Address address) {
        addresses.remove(address);
    }
}
