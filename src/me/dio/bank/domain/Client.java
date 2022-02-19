package me.dio.bank.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private List<Account> accounts;

    public Client() {
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
