package com.ing.tech.database;

import com.ing.tech.data.Account;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Integer, Account> accounts = new HashMap<>();

    public Database() {
        accounts.put(1, new Account(1, 1, 1000));
        accounts.put(2, new Account(2, 2, 500));
        accounts.put(3, new Account(3, 3, 7000));
    }

    public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }

}