package org.amaap.merchantsguidetogalaxy.controller;

import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

public class InterGalacticTransactionController {
    public double calculateCredits(String query) {
        InterGalacticTransactionService interGalacticTransactionService = new InterGalacticTransactionService();
        return interGalacticTransactionService.calculateCredits(query);
    }
}
