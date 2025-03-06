package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TransactionProcessorApp app = new TransactionProcessorApp();
        String[] values = {
                "10100712345670000200000",
                "1010064447770000100000",
                "10100712345670000080000",
                "1010062345910000040000",
                "1010064447770000050000",
                "1010061111110000200000",
                "1020064447770000020000",
                "1020064447770000020000",
                "10200712345670000020000",
                "10200712345670000020000",
                "10200712345670000015000",
                "1020062345910000030000",
                "1020061111110000010000"
        };

        app.processTransactions(values);
    }
}