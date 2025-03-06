import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

// Enum for transaction types
enum TransactionType {
    DEPOSIT, WITHDRAWAL, TRANSFER, INVALID
}

class Transaction {
    private final TransactionType operation;
    private final String sourceAccountId;
    private final String destinationAccountId;
    private final double amount;

    public Transaction(TransactionType operation, String sourceAccountId, String destinationAccountId, double amount) {
        this.operation = operation;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.amount = amount;
    }

    public TransactionType getOperation() {
        return operation;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public double getAmount() {
        return amount;
    }
}