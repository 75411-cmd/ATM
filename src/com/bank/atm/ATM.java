package com.bank.atm;

import com.bank.model.BankAccount;
import com.bank.util.InputHandler;

/**
 * ATM System
 * Demonstrates use of abstraction and polymorphism
 */
public class ATM {
    private BankAccount[] accounts;
    private InputHandler inputHandler;

    public ATM(BankAccount[] accounts) {
        this.accounts = accounts;
        this.inputHandler = new InputHandler();
    }

    public void start() {
        System.out.println("\n==============================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("==============================");

        BankAccount account = login();
        if (account != null) {
            showMenu(account);
        }
        inputHandler.close();
    }

    private BankAccount login() {
        System.out.print("\nEnter Card Number: ");
        String card = inputHandler.readLine();

        for (BankAccount account : accounts) {
            if (account.getCardNumber().equals(card)) {
                for (int tries = 3; tries > 0; tries--) {
                    System.out.print("Enter PIN: ");
                    String pin = inputHandler.readLine();

                    if (account.verifyPin(pin)) {
                        System.out.println("\n  Login Successful! Welcome.");
                        System.out.println("  " + account);
                        return account;
                    }
                    System.out.println("  Wrong PIN. Attempts remaining: " + (tries - 1));
                }
                System.out.println("\n  Card blocked due to too many failed attempts.");
                return null;
            }
        }
        System.out.println("\n  Card not found.");
        return null;
    }

    private void showMenu(BankAccount account) {
        int choice;
        do {
            System.out.println("\n------------------------------");
            System.out.println("          ATM MENU");
            System.out.println("------------------------------");
            System.out.println("  1. Check Balance");
            System.out.println("  2. Deposit");
            System.out.println("  3. Withdraw");
            System.out.println("  4. Transaction History");
            System.out.println("  5. Change PIN");
            System.out.println("  6. Exit");
            System.out.println("------------------------------");
            System.out.print("Choose an option: ");

            choice = inputHandler.readInt();
            System.out.println();

            switch (choice) {
                case 1: checkBalance(account); break;
                case 2: depositMoney(account); break;
                case 3: withdrawMoney(account); break;
                case 4: showHistory(account); break;
                case 5: changePin(account); break;
                case 6: System.out.println("  Thank you for using ATM. Goodbye!"); break;
                default: System.out.println("  Invalid option. Please choose 1-6.");
            }
        } while (choice != 6);
    }

    private void checkBalance(BankAccount account) {
        System.out.printf("  Current Balance: Rs. %.2f%n", account.getBalance());
    }

    private void depositMoney(BankAccount account) {
        System.out.print("  Enter deposit amount: Rs. ");
        double amount = inputHandler.readDouble();
        if (amount > 0) {
            account.deposit(amount);
        }
    }

    private void withdrawMoney(BankAccount account) {
        System.out.print("  Enter withdrawal amount: Rs. ");
        double amount = inputHandler.readDouble();
        if (amount > 0) {
            account.withdraw(amount);
        }
    }

    private void showHistory(BankAccount account) {
        System.out.println("  -- Transaction History -------------------");
        account.printHistory();
        System.out.println("  ------------------------------------------");
    }

    private void changePin(BankAccount account) {
        System.out.print("  Enter current PIN to confirm: ");
        String current = inputHandler.readLine();
        if (!account.verifyPin(current)) {
            System.out.println("  Wrong PIN. PIN not changed.");
            return;
        }
        System.out.print("  Enter new PIN: ");
        String newPin = inputHandler.readLine();
        System.out.print("  Confirm new PIN: ");
        String confirm = inputHandler.readLine();
        if (!newPin.equals(confirm)) {
            System.out.println("  PINs do not match. PIN not changed.");
            return;
        }
        account.setPin(newPin);
        System.out.println("  PIN changed successfully.");
    }
}
