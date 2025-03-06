public class TransactionProcessorApp {
    private static final Logger logger = Logger.getLogger(TransactionProcessorApp.class.getName());

    public static void main(String[] args) {
        String[] transactions = {
            "10100712345670000200000",
            "1020071234567000000500",
            "103006111111062345910000010000"
        };

        logger.info("Starting Transaction Processor");
        Bank bank = new Bank();

        for (String transaction : transactions) {
            try {
                Transaction parsedTransaction = TransactionParser.parse(transaction.trim());
                bank.processTransaction(parsedTransaction);
            } catch (Exception e) {
                logger.warning("Error processing transaction: " + transaction + " - " + e.getMessage());
            }
        }

        bank.showBalance();
        logger.info("Transaction processing completed.");
    }
}