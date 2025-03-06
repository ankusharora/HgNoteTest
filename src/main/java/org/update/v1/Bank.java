package org.update.v1;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void processTransaction(Transaction transaction) {
        accounts.putIfAbsent(transaction.getAccountId(), new BankAccount(transaction.getAccountId(), 0));
        BankAccount account = accounts.get(transaction.getAccountId());

        switch (transaction.getOperation()) {
            case DEPOSIT -> {
                if (transaction.getAmount() <= 100000) {
                    account.deposit(transaction.getAmount());
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Deposit amount exceeds limit.");
                }
            }
            case WITHDRAWAL -> {
                if (!account.withdraw(transaction.getAmount())) {
                    System.out.println("Withdrawal failed: insufficient funds or exceeds limit.");
                } else {
                    System.out.println("Withdrawal successful.");
                }
            }
            default -> System.out.println("Invalid transaction operation.");
        }
    }

    public void showBalance() {
        accounts.forEach((id, acc) -> System.out.println("Account: " + id + " - Balance: $" + acc.getBalance()));
    }
}
