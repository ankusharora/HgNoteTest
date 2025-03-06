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

        if (operation == TransactionType.INVALID) {
            throw new IllegalArgumentException("Invalid transaction type.");
        }

        try {
            int accountNoLength = Integer.parseInt(transaction.substring(4, 6));
            int minLength = 6 + accountNoLength + 1; // Ensuring we have at least one digit for the amount

            if (transaction.length() < minLength) {
                throw new IllegalArgumentException("Invalid transaction: Account number not correct.");
            }

            String accountNo = transaction.substring(6, 6 + accountNoLength);
            double amount = Double.parseDouble(transaction.substring(6 + accountNoLength)) / 100.0;

            return new Transaction(operation, accountNo, amount);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid transaction format.");
        }

//        //1030 06 111111   062345910000010000
//        //
//        int accountNoLength = Integer.parseInt(transaction.substring(4, 6));
//        String accountNo = transaction.substring(6, 6 + accountNoLength);
//        double amount = Double.parseDouble(transaction.substring(6 + accountNoLength)) / 100.0; // Convert cents to dollars
//
//        return new Transaction(operation, accountNo, amount);
    }
}
