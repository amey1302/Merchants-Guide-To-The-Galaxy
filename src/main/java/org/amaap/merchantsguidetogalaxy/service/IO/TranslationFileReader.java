package org.amaap.merchantsguidetogalaxy.service.IO;

import org.amaap.merchantsguidetogalaxy.service.IO.exception.IllegalPathExtensionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TranslationFileReader {
    public List<String> readFile(String filePath) throws IOException, IllegalPathExtensionException {
        validateFilePath(filePath);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    private void validateFilePath(String filePath) throws IllegalPathExtensionException {
        if (!filePath.endsWith(".txt")) {
            throw new IllegalPathExtensionException("File must have .txt extension");
        }
    }
}
