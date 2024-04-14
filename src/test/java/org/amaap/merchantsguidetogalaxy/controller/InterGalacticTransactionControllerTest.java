package org.amaap.merchantsguidetogalaxy.controller;

import org.amaap.merchantsguidetogalaxy.service.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterGalacticTransactionControllerTest {
    InterGalacticTransactionController controller;

    @BeforeEach
    void setUp() {
        controller = new InterGalacticTransactionController
                (new InterGalacticTransactionService(new TranslationFileReader()));
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
