package org.amaap.merchantsguidetogalaxy.service;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InterGalacticTransactionService {
    private TranslationFileReader translationFileReader;
    private TranslationFileParser translationFileParser;
    @Inject

    public InterGalacticTransactionService(TranslationFileReader translationFileReader, TranslationFileParser translationFileParser) {
        this.translationFileReader = translationFileReader;
        this.translationFileParser = translationFileParser;
    }

    @Inject


    public double calculateCredits(String query) {
        return 68;
    }

    public List<String> readFile(String filePath) throws IOException, IllegalPathExtensionException {
        return translationFileReader.readFile(filePath);
    }

    public Map<String, String> parser(List<String> lines) {
        return translationFileParser.parse(lines) ;
    }
}
