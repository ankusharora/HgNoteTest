package org.updade.v1;

import org.junit.jupiter.api.*;
import org.update.v1.TransactionProcessorApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class TransactionProcessorAppTest {

    @BeforeEach
    void setUp() {
        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    public void processTransactionsTest() {
        String[] inputFileLines = loadFile();
        TransactionProcessorApp app = new TransactionProcessorApp();
        app.processTransactions(inputFileLines);
    }

    private String[] loadFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/input.txt"));
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file", e);
        }
    }
}
