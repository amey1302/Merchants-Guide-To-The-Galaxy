package org.amaap.merchantsguidetogalaxy.controller;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.service.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

public class InterGalacticTransactionController {
    private InterGalacticTransactionService interGalacticTransactionService;

    @Inject
    public InterGalacticTransactionController(InterGalacticTransactionService interGalacticTransactionService) {
        this.interGalacticTransactionService = interGalacticTransactionService;
    }

    public double calculateCredits(String query) {
        TranslationFileReader fileReader = new TranslationFileReader();
        InterGalacticTransactionService interGalacticTransactionService = new InterGalacticTransactionService(fileReader);
        return interGalacticTransactionService.calculateCredits(query);
    }
}
