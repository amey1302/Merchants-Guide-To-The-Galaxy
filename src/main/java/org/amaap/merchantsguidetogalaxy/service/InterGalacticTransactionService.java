package org.amaap.merchantsguidetogalaxy.service;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.service.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.IO.exception.IllegalPathExtensionException;

import java.io.IOException;
import java.util.List;

public class InterGalacticTransactionService {
    private TranslationFileReader translationFileReader;

    @Inject
    public InterGalacticTransactionService(TranslationFileReader translationFileReader) {
        this.translationFileReader = translationFileReader;
    }

    public double calculateCredits(String query) {
        return 68;
    }

    public List<String> readFile(String filePath) throws IOException, IllegalPathExtensionException {
        return translationFileReader.readFile(filePath);
    }
}
