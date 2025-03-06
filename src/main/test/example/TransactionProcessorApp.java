package org.example;

public class TransactionProcessorApp {

    public static final String WITHDRAWAL = "Withdrawal";

    private Transaction parseRequest(String transaction){
        String operation = transaction.substring(0, 4);
        if (operation.equals("1010")){
            operation = "Deposit";
        } else if (operation.equals("1020")) {
            operation = TransactionProcessorApp.WITHDRAWAL;
        } else {
            operation = "Invalid";
        }
        int accountNoLength = Integer.parseInt(transaction.substring(4,6));
        String accountNo = transaction.substring(6,(6+accountNoLength));
        double balance = Double.parseDouble(transaction.substring((6+accountNoLength)));

//        System.out.println("Operation: "+ operation);
//
//        System.out.println("accountNoLength: "+ accountNoLength);
//        System.out.println("accountNo: "+ accountNo);
//        System.out.println("balance: "+ balance);

        return new Transaction(operation, accountNo, balance);
    }

    public void processTransactions(String[] transactions) {
        System.out.println("Starting Transaction Processor");
        System.out.println("Start Inputs");
        // 10100712345670000200000

        // 1. parse the transactions one by one and
        // 2. execute the operation
        // 3. Check for all contrains for deposit and withdrawal
        // 4. Ensure the system is showing the balance
        Bank bank = new Bank();
        for (String transaction : transactions){

            Transaction currentTrasaction = parseRequest(transaction.trim());

            if (currentTrasaction.getOperation().equals("Deposit")){
                bank.deposit(currentTrasaction);
            } else if (currentTrasaction.getOperation().equals("Withdrawal")){
                bank.withdrawal(currentTrasaction);
            } else {
                System.out.println("Invalid Operation");
            }
            System.out.println(transaction);
        }
//  10100712345670000200000

        bank.showBalance();
        System.out.println("End Inputs");
    }
}