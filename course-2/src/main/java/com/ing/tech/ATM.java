package com.ing.tech;

import com.ing.tech.transaction.*;

public class ATM {

    private Screen screen;
    private Keypad keypad;
    private Database database;

    private Account currentUser;

    public ATM() {
        screen = new Screen();
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
                screen.displayMessage("You balance is " + currentUser.getBalance());
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
                screen.displayMessage("Invalid command");
                break;
        }

        return true;
    }

    private void executeTransaction(TransactionType type) {
        screen.displayMessage("Enter the amount");
        Transaction transaction = createTransaction(type);
        double amount = keypad.getAmount();

        try {
            transaction.execute(currentUser, amount);
        } catch (TransactionException | NullPointerException e) {
            screen.displayMessage(e.getMessage());
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
        screen.displayMessage("Welcome to ING");
        screen.displayMessage("Please insert your account number: ");
        int accountNumber = keypad.getInput();
        screen.displayMessage("Please insert your pin: ");
        int pin = keypad.getInput();

        Account account = database.getAccount(accountNumber);
        if (account == null) {
            screen.displayMessage("Incorrect login information");
            return;
        }

        if(!account.checkPin(pin)) {
            screen.displayMessage("Incorrect login information");
            return;
        }

        currentUser = account;
        screen.displayMessage("You're successfully authenticated");
    }

    private void showMenu() {
        screen.displayMessage("-----------------------------------------------");
        screen.displayMessage("Choose one of the following actions:");
        screen.displayMessage("1. View balance.");
        screen.displayMessage("2. Deposit.");
        screen.displayMessage("3. Withdraw.");
        screen.displayMessage("4. Logout.");
        screen.displayMessage("5. Exit.");
    }
}
