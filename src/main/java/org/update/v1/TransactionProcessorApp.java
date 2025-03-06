package org.update.v1;
public class TransactionProcessorApp {
    public void processTransactions(String[] transactions) {

                //103006111111062345910000010000
        System.out.println("Starting Transaction Processor");
        Bank bank = new Bank();

        for (String transaction : transactions) {
            try {
                Transaction parsedTransaction = TransactionParser.parse(transaction.trim());
                bank.processTransaction(parsedTransaction);
            } catch (Exception e) {
                System.out.println("Error processing transaction: " + transaction + " - " + e.getMessage());
            }
        }

        bank.showBalance();
        System.out.println("------------------------------- Transaction processing completed. -------------------------------");
    }
}
