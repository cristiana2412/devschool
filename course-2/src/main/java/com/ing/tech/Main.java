package com.ing.tech;

import java.util.*;

public class Main {
    private static boolean loggedSuccessful = false;
    private static List<User> users;
    private static String username;
    private static User currentUser;
    private static Scanner keypad = new Scanner (System.in);

    public static void main(String[] args) {

        Map<String, Account> BankDatabase = Map.of(
                "user@mail.com",new Account(500),
                "ana@maria.ro",new Account(346),
                "maria@ioana.ro",new Account(4378)
        );
        initializeUsers();
        while (!loggedSuccessful){
            login();
        }

    }

    private static void initializeUsers(){
        users = new ArrayList<>();
        users.add(new User("user@mail.com","abcd", new Account(500)));
        users.add(new User("ana@maria.ro","qwer", new Account(760)));
        users.add(new User("maria@ioana.com","zxcv", new Account(230)));
        users.add(new User("ion@mail.com","asdf", new Account(150)));
    }

    private static void login(){
        String password;
        System.out.println("\nEnter your username and password to login to your account.");

        System.out.println("Username: ");
        username = keypad.nextLine();

        System.out.println("Password: ");
        password = keypad.nextLine();

        for (User user : users) {
            if ((username.equals(user.getUsername())) &&
                    (password.equals(user.getPassword()))) {
                loggedSuccessful = true;
                currentUser = user;
            }
        }
        if(!loggedSuccessful){
            System.out.println("Incorrect login!");
        } else {
            System.out.println("Successful login.");
        }
    }

    public static void logout(){
        currentUser=null;
        loggedSuccessful=false;
        username=null;
    }

    class ATM {
        int opt = 0;
        void showMainMenu(){
            System.out.println("Choose the desired action:");
            System.out.println("1. View my balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Exit");
        }
        int getOption(){
            return Integer.parseInt(keypad.nextLine());
        }
        void showBalance(){
            System.out.println("Current balance\n" + currentUser.getAccount().getBalance());
        }
        void deposit(){
            System.out.println("Choose the desire amount:\n");
        }

    }
}
