package com.ing.tech.transaction;

import com.ing.tech.data.Account;
import com.ing.tech.exception.TransactionException;
import org.springframework.stereotype.Component;

@Component
public class Withdraw  implements Transaction {

    @Override
    public void execute(Account account, double amount) {
        if (amount < 0 || amount > account.getBalance()) {
            throw new TransactionException("Withdraw failed");
        }

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
    }

}