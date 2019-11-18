package com.ing.tech.controller;

import com.ing.tech.data.Account;
import com.ing.tech.database.Database;
import com.ing.tech.exception.TransactionException;
import com.ing.tech.peripheral.Keypad;
import com.ing.tech.peripheral.Screen;
import com.ing.tech.transaction.Deposit;
import com.ing.tech.transaction.Transaction;
import com.ing.tech.transaction.TransactionType;
import com.ing.tech.transaction.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATM {

    private Keypad keypad;
    private Database database;
    private Account currentUser;

    @Bean
    Screen getScreen(){
        return new Screen();
    }

    public ATM() {
        keypad = new Keypad();
        database = new Database();
    }

    public void run() {
        while(true) {
            if (currentUser == null) {
                login();
                continue;
            }
            showMenu();

            int actionChosen = keypad.getInput();

            if (!executeAction(actionChosen)) {
                return;
            }
        }
    }

    private boolean executeAction(int actionChosen) {
        switch (actionChosen) {
            case 1:
                getScreen().displayMessage("You balance is " + currentUser.getBalance());
                break;
            case 2:
                executeTransaction(TransactionType.DEPOSIT);
                break;
            case 3:
                executeTransaction(TransactionType.WITHDRAW);
                break;
            case 4:
                currentUser = null;
                break;
            case 5:
                return false;
            default:
                getScreen().displayMessage("Invalid command");
                break;
        }

        return true;
    }

    private void executeTransaction(TransactionType type) {
        getScreen().displayMessage("Enter the amount");
        Transaction transaction = createTransaction(type);
        double amount = keypad.getAmount();

        try {
            transaction.execute(currentUser, amount);
        } catch (TransactionException | NullPointerException e) {
            getScreen().displayMessage(e.getMessage());
        }
    }

    private Transaction createTransaction(TransactionType type) {
        switch (type) {
            case DEPOSIT:
                return new Deposit();
            case WITHDRAW:
                return new Withdraw();
            default:
                return null;
        }
    }


    private void login() {
        getScreen().displayMessage("Welcome to ING");
        getScreen().displayMessage("Please insert your account number: ");
        int accountNumber = keypad.getInput();
        getScreen().displayMessage("Please insert your pin: ");
        int pin = keypad.getInput();

        Account account = database.getAccount(accountNumber);
        if (account == null) {
            getScreen().displayMessage("Incorrect login information");
            return;
        }

        if(!account.checkPin(pin)) {
            getScreen().displayMessage("Incorrect login information");
            return;
        }

        currentUser = account;
        getScreen().displayMessage("You're successfully authenticated");
    }

    private void showMenu() {
        getScreen().displayMessage("-----------------------------------------------");
        getScreen().displayMessage("Choose one of the following actions:");
        getScreen().displayMessage("1. View balance.");
        getScreen().displayMessage("2. Deposit.");
        getScreen().displayMessage("3. Withdraw.");
        getScreen().displayMessage("4. Logout.");
        getScreen().displayMessage("5. Exit.");
    }
}
