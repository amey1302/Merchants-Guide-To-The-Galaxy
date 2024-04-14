package org.amaap.merchantsguidetogalaxy.controller;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

public class InterGalacticTransactionController {
    private InterGalacticTransactionService interGalacticTransactionService;

    @Inject
    public InterGalacticTransactionController(InterGalacticTransactionService interGalacticTransactionService) {
        this.interGalacticTransactionService = interGalacticTransactionService;
    }

    public double calculateCredits(String query) {
        TranslationFileReader fileReader = new TranslationFileReader();
        TranslationFileParser fileParser = new TranslationFileParser();


        InterGalacticTransactionService interGalacticTransactionService = new
                InterGalacticTransactionService(fileReader,fileParser);
        return interGalacticTransactionService.calculateCredits(query);
    }
}
