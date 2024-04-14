package org.amaap.merchantsguidetogalaxy.service;

import org.amaap.merchantsguidetogalaxy.service.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.service.IO.exception.IllegalPathExtensionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterGalacticTransactionServiceTest {
    TranslationFileReader translationFileReader;
    InterGalacticTransactionService service;

    @BeforeEach
    void setUp() {
        translationFileReader = new TranslationFileReader();
        service = new InterGalacticTransactionService(translationFileReader);
    }

    @Test
    void shouldBeABleToReadDataFromFile() throws IOException, IllegalPathExtensionException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\test\\resources\\TranslationData.txt";

        // act
        List<String> lines = service.readFile(filePath);

        // assert
        assertEquals(12, lines.size());
        assertEquals("glob is I", lines.get(0));
    }

}