package org.amaap.merchantsguidetogalaxy.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InterGalacticTransactionService {
    public double calculateCredits(String query) {
        return 68;
    }
    public String readFile(String filePath) throws IOException {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
