package org.amaap.merchantsguidetogalaxy.service;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileProcessorService {
    private TranslationFileReader translationFileReader;
    private TranslationFileParser translationFileParser;
    @Inject
    public FileProcessorService(TranslationFileReader translationFileReader, TranslationFileParser translationFileParser) {
        this.translationFileReader = translationFileReader;
        this.translationFileParser = translationFileParser;
    }


    public Map<String, String> readFileAndParse(String filePath) throws IllegalPathExtensionException, IOException {
        List<String> lines = translationFileReader.readFile(filePath);
        return translationFileParser.parse(lines);
    }
}
