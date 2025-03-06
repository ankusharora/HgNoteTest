class Bank {
    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void processTransaction(Transaction transaction) {
        accounts.putIfAbsent(transaction.getSourceAccountId(), new BankAccount(transaction.getSourceAccountId(), 0));
        if (transaction.getDestinationAccountId() != null) {
            accounts.putIfAbsent(transaction.getDestinationAccountId(), new BankAccount(transaction.getDestinationAccountId(), 0));
        }

        switch (transaction.getOperation()) {
            case DEPOSIT -> {
                if (transaction.getAmount() <= 100000) {
                    accounts.get(transaction.getSourceAccountId()).deposit(transaction.getAmount());
                    logger.info("Deposit successful.");
                } else {
                    logger.warning("Deposit amount exceeds limit.");
                }
            }
            case WITHDRAWAL -> {
                if (!accounts.get(transaction.getSourceAccountId()).withdraw(transaction.getAmount())) {
                    logger.warning("Withdrawal failed: insufficient funds or exceeds limit.");
                } else {
                    logger.info("Withdrawal successful.");
                }
            }
            case TRANSFER -> {
                BankAccount source = accounts.get(transaction.getSourceAccountId());
                BankAccount destination = accounts.get(transaction.getDestinationAccountId());
                if (source.getBalance() >= transaction.getAmount()) {
                    source.withdraw(transaction.getAmount());
                    destination.deposit(transaction.getAmount());
                    logger.info("Transfer successful from " + source.getAccountId() + " to " + destination.getAccountId());
                } else {
                    logger.warning("Transfer failed: insufficient funds.");
                }
            }
            default -> logger.warning("Invalid transaction operation.");
        }
    }

    public void showBalance() {
        accounts.forEach((id, acc) -> logger.info("Account: " + id + " - Balance: $" + acc.getBalance()));
    }
}