package com.ing.tech.transaction;

import com.ing.tech.data.Account;

public interface Transaction {

    void execute(Account account, double amount);

}