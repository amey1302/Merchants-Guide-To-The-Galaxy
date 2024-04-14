package org.amaap.merchantsguidetogalaxy.service;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InterGalacticTransactionServiceTest {
    TranslationFileReader fileReader;
    TranslationFileParser fileParser;
    InterGalacticTransactionService service;

    @BeforeEach
    void setUp() {
        fileParser = new TranslationFileParser();
        fileReader = new TranslationFileReader();

        service = new InterGalacticTransactionService(fileReader, fileParser);
    }

    @Test
    void shouldBeABleToReadDataFromFile() throws IOException, IllegalPathExtensionException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\test\\resources\\TranslationData.txt";

        // act
        List<String> lines = fileReader.readFile(filePath);

        // assert
        assertEquals(12, lines.size());
        assertEquals("glob is I", lines.get(0));
    }

    @Test
    void shouldBeAbleToParseLinesAndReturnMaps() throws IllegalPathExtensionException, IOException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\test\\resources\\TranslationData.txt";
        Map<String, String> unitMap = new HashMap<>();
        unitMap.put("glob", "I");
        unitMap.put("tegj", "L");
        unitMap.put("prok", "V");
        unitMap.put("pish", "I");

        // act
        Map<String, String> result = service.readFileAndParse(filePath);

        // assert
        assertNotNull(result);
        assertTrue(result.get("unitMap").contains("glob=I"));
        assertTrue(result.get("creditMap").contains("glob glob Silver=34"));
        assertTrue(result.get("questionMap").contains("how many Credits is glob prok Silver ?"));

    }
}