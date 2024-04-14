package org.amaap.merchantsguidetogalaxy.service;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InterGalacticTransactionService {
    private TranslationFileReader translationFileReader;
    private TranslationFileParser translationFileParser;
    private InterGalacticRepository repository;
    private HashMap<String,String > resultMap = new LinkedHashMap<>();
    @Inject
    public InterGalacticTransactionService(TranslationFileReader translationFileReader,
                                           TranslationFileParser translationFileParser,
                                           InterGalacticRepository repository) {
        this.translationFileReader = translationFileReader;
        this.translationFileParser = translationFileParser;
        this.repository = repository;
    }



    public double calculateCredits(String query) {
        return 68;
    }

    public void readFileAndParse(String filePath) throws IOException, IllegalPathExtensionException {
        List<String> lines = translationFileReader.readFile(filePath);
        resultMap = translationFileParser.parse(lines);
        repository.insert(resultMap);

    }

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }
}
