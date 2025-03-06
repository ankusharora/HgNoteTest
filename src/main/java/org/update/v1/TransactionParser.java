package org.update.v1;

class TransactionParser {
    public static Transaction parse(String transaction) {
        if (transaction.length() < 8) throw new IllegalArgumentException("Invalid transaction format");

        String code = transaction.substring(0, 4);
        TransactionType operation = switch (code) {
            case "1010" -> TransactionType.DEPOSIT;
            case "1020" -> TransactionType.WITHDRAWAL;
            default -> TransactionType.INVALID;
        };

        //1030 06 111111   062345910000010000
        //
        int accountNoLength = Integer.parseInt(transaction.substring(4, 6));
        String accountNo = transaction.substring(6, 6 + accountNoLength);
        double amount = Double.parseDouble(transaction.substring(6 + accountNoLength)) / 100.0; // Convert cents to dollars

        return new Transaction(operation, accountNo, amount);
    }
}
