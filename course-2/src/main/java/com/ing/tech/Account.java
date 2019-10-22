package com.ing.tech;

import lombok.Data;

import java.util.Map;

@Data
public class Account {
    private static int accountNo = 0;
    private double balance;

    public Account(double balance){
        this.balance = balance;
        this.accountNo++;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdraw(double amount){
        this.balance -= amount;
    }
}
