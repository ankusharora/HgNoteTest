class TransactionParser {
    public static Transaction parse(String transaction) {
        if (transaction.length() < 8) throw new IllegalArgumentException("Invalid transaction format");

        String code = transaction.substring(0, 4);
        TransactionType operation = switch (code) {
            case "1010" -> TransactionType.DEPOSIT;
            case "1020" -> TransactionType.WITHDRAWAL;
            case "1030" -> TransactionType.TRANSFER;
            default -> TransactionType.INVALID;
        };

        if (operation == TransactionType.TRANSFER) {
            int sourceAccountLength = Integer.parseInt(transaction.substring(4, 6));
            int destAccountLength = Integer.parseInt(transaction.substring(6, 8));
            String sourceAccount = transaction.substring(8, 8 + sourceAccountLength);
            String destAccount = transaction.substring(8 + sourceAccountLength, 8 + sourceAccountLength + destAccountLength);
            double amount = Double.parseDouble(transaction.substring(8 + sourceAccountLength + destAccountLength)) / 100.0;
            return new Transaction(operation, sourceAccount, destAccount, amount);
        } else {
            int accountNoLength = Integer.parseInt(transaction.substring(4, 6));
            String accountNo = transaction.substring(6, 6 + accountNoLength);
            double amount = Double.parseDouble(transaction.substring(6 + accountNoLength)) / 100.0;
            return new Transaction(operation, accountNo, null, amount);
        }
    }
}