package com.bank.main;

import com.bank.account.SavingsAccount;
import com.bank.account.CurrentAccount;
import com.bank.model.BankAccount;
import com.bank.atm.ATM;

/**
 * Main entry point for ATM System
 */
public class Main {

    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("1111222233334444", "1234", 5000.0),
            new SavingsAccount("5555666677778888", "4321", 12000.0),
            new CurrentAccount("9999000011112222", "5678", 3000.0, 1000.0),
            new CurrentAccount("3333444455556666", "8765", 8000.0, 5000.0)
        };

        ATM atm = new ATM(accounts);
        atm.start();
    }
}
