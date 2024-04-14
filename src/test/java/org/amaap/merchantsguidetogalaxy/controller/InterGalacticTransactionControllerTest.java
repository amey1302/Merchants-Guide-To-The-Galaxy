package org.amaap.merchantsguidetogalaxy.controller;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterGalacticTransactionControllerTest {
    TranslationFileReader translationFileReader;
    TranslationFileParser translationFileParser;
    InterGalacticTransactionService service;
    InterGalacticTransactionController controller;

    @BeforeEach
    void setUp() {
        translationFileParser = new TranslationFileParser();
        translationFileReader = new TranslationFileReader();
        service = new InterGalacticTransactionService(translationFileReader, translationFileParser);
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
