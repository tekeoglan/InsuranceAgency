package com.tekeoglan.insuranceagency;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountManager {
    TreeSet<Account> accounts;

    Account current;

    public AccountManager() {
        this.accounts = new TreeSet<>();
    }

    public void register(Account account) {
        this.accounts.add(account);
    }

    public void login(String email, String password) {
        if (this.accounts.isEmpty()) {
            System.out.println("there is no user in the system");
        }

        List<Account> refineAccounts = this.accounts.stream().filter(account -> account.getUser().email.equals(email)).toList();
        if (refineAccounts.isEmpty()) {
            System.out.println("there is no user exists with this email");
            return;
        } else {
            try {
                refineAccounts.get(0).login(email, password);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        this.current = refineAccounts.get(0);
    }

    public Account getCurrent() {
        return this.current;
    }

    public boolean isEmailExists(String email) {
        if (accounts.isEmpty()) return false;

        List<Account> accounts = this.accounts.stream().filter(account -> account.getUser().email.equals(email)).toList();
        return accounts.size() > 1;
    }
}
