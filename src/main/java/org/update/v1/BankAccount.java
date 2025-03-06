package org.update.v1;

class BankAccount {
    private final String accountId;
    private double balance;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance || amount > 500) { // Restrict withdrawal to $500 at one time/day
            return false;
        }
        balance -= amount;
        return true;
    }

    public String getAccountId() {
        return accountId;
    }
}
