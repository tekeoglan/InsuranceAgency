package com.tekeoglan.insuranceagency;

public class InvalidAuthanticationException extends Exception {
    InvalidAuthanticationException() {
        super("Invalid email or password.");
    }
}
