package com.bank.model;

/**
 * Abstract base class for bank accounts
 * Demonstrates Abstraction and Encapsulation
 */
public abstract class BankAccount {
    private String cardNumber;
    private String pin;
    private double balance;
    private String[] transactionHistory;
    private int historyCount;
    private static final int MAX_HISTORY = 50;

    public BankAccount(String cardNumber, String pin, double initialBalance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new String[MAX_HISTORY];
        this.historyCount = 0;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean verifyPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void setPin(String newPin) {
        this.pin = newPin;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void addHistory(String record) {
        if (historyCount < MAX_HISTORY) {
            transactionHistory[historyCount++] = record;
        }
    }

    public void printHistory() {
        if (historyCount == 0) {
            System.out.println("  No transactions yet.");
        } else {
            for (int i = 0; i < historyCount; i++) {
                System.out.println("  " + transactionHistory[i]);
            }
        }
    }

    // Abstract methods - demonstrates Abstraction
    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract String toString();
}
