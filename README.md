# Simplified ATM System

## Project Structure

This is a simplified implementation of an ATM system demonstrating core OOP concepts.

### Package Organization

```
src/com/bank/
├── model/          - Abstract base classes (BankAccount)
├── account/        - Concrete account implementations (SavingsAccount, CurrentAccount)
├── util/           - Utility classes (InputHandler)
├── atm/            - ATM system logic (ATM)
└── main/           - Entry point (Main)
```

## OOP Concepts Demonstrated

1. **Encapsulation**: Private fields with public getters/setters
2. **Inheritance**: SavingsAccount and CurrentAccount extend BankAccount
3. **Abstraction**: Abstract BankAccount class with abstract methods
4. **Polymorphism**: deposit() and withdraw() implemented differently in subclasses

## Features

- User login with PIN verification
- Check balance
- Deposit money
- Withdraw money
- View transaction history
- Change PIN
- Support for both Savings and Current accounts
- Overdraft facility for Current accounts
- Minimum balance requirement for Savings accounts

## How to Run

```bash
javac -d bin src/com/bank/model/*.java src/com/bank/account/*.java src/com/bank/util/*.java src/com/bank/atm/*.java src/com/bank/main/*.java
java -cp bin com.bank.main.Main
```

## Test Accounts

### Savings Accounts
- Card: 1111222233334444, PIN: 1234, Balance: Rs. 5000
- Card: 5555666677778888, PIN: 4321, Balance: Rs. 12000

### Current Accounts
- Card: 9999000011112222, PIN: 5678, Balance: Rs. 3000 (Overdraft: Rs. 1000)
- Card: 3333444455556666, PIN: 8765, Balance: Rs. 8000 (Overdraft: Rs. 5000)
