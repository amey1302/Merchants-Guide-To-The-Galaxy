package org.amaap.merchantsguidetogalaxy.controller;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

import java.util.Map;

public class InterGalacticTransactionController {
    private InterGalacticTransactionService interGalacticTransactionService;

    @Inject
    public InterGalacticTransactionController(InterGalacticTransactionService interGalacticTransactionService) {
        this.interGalacticTransactionService = interGalacticTransactionService;
    }

    public String calculateCredits(Map<String, String> query) {
        return null;
        //return interGalacticTransactionService.calculateCredits(query);
    }
}
