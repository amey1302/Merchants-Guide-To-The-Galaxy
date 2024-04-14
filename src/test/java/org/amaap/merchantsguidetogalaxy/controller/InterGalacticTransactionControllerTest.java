package org.amaap.merchantsguidetogalaxy.controller;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.InMemoryInterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterGalacticTransactionControllerTest {
    private InMemoryDataBase inMemoryDataBase;
    InterGalacticRepository repository;
    TranslationFileReader translationFileReader;
    TranslationFileParser translationFileParser;
    InterGalacticTransactionService service;
    InterGalacticTransactionController controller;

    @BeforeEach
    void setUp() {
        inMemoryDataBase = new FakeDatabase();
        repository = new InMemoryInterGalacticRepository(inMemoryDataBase);
        translationFileParser = new TranslationFileParser();
        translationFileReader = new TranslationFileReader();
        service = new InterGalacticTransactionService(translationFileReader, translationFileParser,repository);
        controller = new InterGalacticTransactionController(service);
    }

    @Test
    void shouldBeAbleToCalculateCreditsForQuery() {
        // arrange
        double expected = 68;
        String query = "how many Credits is glob prok Silver ?";

        // act
        double actual = controller.calculateCredits(query);

        // assert
        assertEquals(expected, actual);
    }
}
