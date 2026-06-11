package com.bank.account;

import com.bank.model.BankAccount;

/**
 * Savings Account implementation
 * Demonstrates Inheritance and Polymorphism
 */
public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500.0;

    public SavingsAccount(String cardNumber, String pin, double initialBalance) {
        super(cardNumber, pin, initialBalance);
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
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.printf("  Insufficient balance. Minimum balance must be Rs. %.2f.%n", MIN_BALANCE);
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
        return "Savings Account [" + getCardNumber() + "] Balance: Rs. " + 
               String.format("%.2f", getBalance()) + " (Min: Rs. " + 
               String.format("%.2f", MIN_BALANCE) + ")";
    }
}
