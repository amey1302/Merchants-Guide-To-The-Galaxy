package org.amaap.merchantsguidetogalaxy.IO;

import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationFileParserTest {

    @Test
    void ShouldBeAbleToParse_ValidInput_ReturnsCorrectMaps() throws IllegalPathExtensionException, IOException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\main" +
                "\\resources\\TranslationData.txt";
        TranslationFileReader reader = new TranslationFileReader();
        List<String> lines = reader.readFile(filePath);

        // act
        TranslationFileParser parser = new TranslationFileParser();
        HashMap<String, String> resultMap = parser.parse(lines);

        // assert
        assertEquals("{glob=I, prok=V, pish=X, tegj=L}", resultMap.get("unitMap"));
        assertEquals("{glob glob Silver=34, glob prok Gold=57800, pish pish Iron=3910 }",
                resultMap.get("creditMap"));
        assertEquals("{how much is pish tegj glob glob ?=, how many Credits is glob prok Silver ?=," +
                " how many Credits is glob prok Gold ?=, how many Credits is glob prok Iron ?=}",
                resultMap.get("questionMap"));
    }

    @Test
    void ShouldBeAbleToParse_EmptyInput_ReturnsEmptyMaps() {
        // Arrange
        List<String> lines = Arrays.asList();

        TranslationFileParser parser = new TranslationFileParser();

        // Act
        Map<String, String> resultMap = parser.parse(lines);

        // Assert
        assertEquals("{}", resultMap.get("unitMap"));
        assertEquals("{}", resultMap.get("creditMap"));
        assertEquals("{}", resultMap.get("questionMap"));
    }

}
