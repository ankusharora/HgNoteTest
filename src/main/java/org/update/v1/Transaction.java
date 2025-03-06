package org.update.v1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

// Enum for transaction types
enum TransactionType {
    DEPOSIT, WITHDRAWAL, INVALID
}

class Transaction {
    private final TransactionType operation;
    private final String accountId;
    private final double amount;

    public Transaction(TransactionType operation, String accountId, double amount) {
        this.operation = operation;
        this.accountId = accountId;
        this.amount = amount;
    }

    public TransactionType getOperation() {
        return operation;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }
}