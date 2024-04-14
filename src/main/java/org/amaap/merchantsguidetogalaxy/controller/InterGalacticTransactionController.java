package org.amaap.merchantsguidetogalaxy.controller;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.InMemoryInterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
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
        InMemoryDataBase inMemoryDataBase = new FakeDatabase();
        InterGalacticRepository repository = new InMemoryInterGalacticRepository(inMemoryDataBase);


        InterGalacticTransactionService interGalacticTransactionService = new
                InterGalacticTransactionService(fileReader,fileParser,repository);
        return interGalacticTransactionService.calculateCredits(query);
    }
}
