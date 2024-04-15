package org.amaap.merchantsguidetogalaxy.service;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.InMemoryInterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InterGalacticTransactionServiceTest {
    InMemoryDataBase inMemoryDataBase;
    InterGalacticRepository repository;

    TranslationFileReader fileReader;
    TranslationFileParser fileParser;
    InterGalacticTransactionService service;


    @BeforeEach
    void setUp() {
        inMemoryDataBase = new FakeDatabase();
        repository = new InMemoryInterGalacticRepository(inMemoryDataBase);
        fileParser = new TranslationFileParser();
        fileReader = new TranslationFileReader();

        service = new InterGalacticTransactionService(fileReader, fileParser,repository);
    }

    @Test
    void shouldBeABleToReadDataFromFile() throws IOException, IllegalPathExtensionException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src" +
                "\\main\\resources\\TranslationData.txt";

        // act
        List<String> lines = fileReader.readFile(filePath);

        // assert
        assertEquals(12, lines.size());
        assertEquals("glob is I", lines.get(0));
    }

    @Test
    void shouldBeAbleToParseLinesAndReturnMaps() throws IllegalPathExtensionException, IOException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\" +
                "src\\main\\resources\\TranslationData.txt";
        HashMap<String, String> unitMap = new LinkedHashMap<>();
        unitMap.put("glob", "I");
        unitMap.put("tegj", "L");
        unitMap.put("prok", "V");
        unitMap.put("pish", "I");

        // act
        service.readFileAndParse(filePath);
        HashMap<String ,String> result = service.getResultMap();

        // assert
        assertNotNull(result);
        assertTrue(result.get("unitMap").contains("glob=I"));
        assertTrue(result.get("creditMap").contains("glob glob Silver=34"));
        assertTrue(result.get("questionMap").contains("how many Credits is glob prok Silver ?"));

    }
}