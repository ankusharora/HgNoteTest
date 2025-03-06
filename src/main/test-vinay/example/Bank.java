package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<String, BankAccount> bank = new HashMap<>();

    public void deposit(Transaction transction) {

        if (!bank.containsKey(transction.getAccountId()))
            bank.put(transction.getAccountId(), new BankAccount(transction.getAccountId(), 0));
        if (transction.getBalance() <= 100000){
            BankAccount acc = bank.get(transction.getAccountId());
            acc.setBalance(acc.getBalance() + transction.getBalance()); // total balance
        }
    }

    public void withdrawal(Transaction transction){
        if (!bank.containsKey(transction.getAccountId()))
            System.out.println("Account does not exist");
        BankAccount acc = bank.get(transction.getAccountId());
        if (transction.getBalance() <= acc.getBalance()){
            acc.setBalance(acc.getBalance() - transction.getBalance()); // total balance
        }
        // logic to restrict it to 500 at one time/day
    }

    public void showBalance (){
        for (BankAccount account : bank.values()){
            System.out.println(String.format("# %s - $%s", account.getAccountId(), String.valueOf(account.getBalance())));

        }
    }
}