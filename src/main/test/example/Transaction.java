package org.example;

public class Transaction {

    private String operation;
    private String accountId;
    private double balance;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Transaction(String operation, String accountId, double balance) {
        this.operation = operation;
        this.accountId = accountId;
        this.balance = balance;
    }
}
