package com.ing.tech.transaction;

import com.ing.tech.Account;

public interface Transaction {

    void execute(Account account, double amount);

}
