package org.amaap.merchantsguidetogalaxy.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterGalacticTransactionControllerTest {
    @Test
    void shouldBeAbleToCalculateCreditsForQuery(){
        // arrange
        InterGalacticTransactionController interGalacticTransactionController = new InterGalacticTransactionController();
        double expected = 68;
        String query = "how many Credits is glob prok Silver ?";

        // act
        double actual = interGalacticTransactionController.calculateCredits(query);

        // assert
        assertEquals(expected,actual);
    }
}
