package com.bank.account;

import com.bank.model.BankAccount;

/**
 * Current Account implementation
 * Demonstrates Inheritance and Polymorphism
 */
public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String cardNumber, String pin, double initialBalance, double overdraftLimit) {
        super(cardNumber, pin, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  Deposit amount must be positive.");
            return false;
        }
        setBalance(getBalance() + amount);
        addHistory("Deposited Rs. " + String.format("%.2f", amount) + 
                   " | Balance: Rs. " + String.format("%.2f", getBalance()));
        System.out.println("  Deposit Successful.");
        return true;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  Withdrawal amount must be positive.");
            return false;
        }
        if (getBalance() - amount < -overdraftLimit) {
            System.out.printf("  Exceeds overdraft limit of Rs. %.2f.%n", overdraftLimit);
            return false;
        }
        setBalance(getBalance() - amount);
        addHistory("Withdrawn Rs. " + String.format("%.2f", amount) + 
                   " | Balance: Rs. " + String.format("%.2f", getBalance()));
        System.out.println("  Withdrawal Successful.");
        return true;
    }

    @Override
    public String toString() {
        return "Current Account [" + getCardNumber() + "] Balance: Rs. " + 
               String.format("%.2f", getBalance()) + " (Overdraft: Rs. " + 
               String.format("%.2f", overdraftLimit) + ")";
    }
}
