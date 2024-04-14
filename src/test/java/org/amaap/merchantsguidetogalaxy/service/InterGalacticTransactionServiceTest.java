package org.amaap.merchantsguidetogalaxy.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InterGalacticTransactionServiceTest {
    @Test
    void shouldBeABleToReadDataFromFile() throws IOException {
        // arrange
        InterGalacticTransactionService service = new InterGalacticTransactionService();
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\test\\resources\\TranslationData.txt";

        // act
        String fileContent = service.readFile(filePath);

        // assert
        assertNotNull(fileContent);
    }

}