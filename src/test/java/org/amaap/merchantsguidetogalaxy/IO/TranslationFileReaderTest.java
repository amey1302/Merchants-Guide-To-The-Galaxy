package org.amaap.merchantsguidetogalaxy.IO;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TranslationFileReaderTest {
    @Test
    void shouldReadFileAndExcludeEmptyLines() throws IOException, IllegalPathExtensionException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\main" +
                "\\resources\\TranslationData.txt";
        TranslationFileReader reader = new TranslationFileReader();

        // act
        List<String> actualLines = reader.readFile(filePath);

        // assert
        assertEquals(12, actualLines.size());
        assertEquals("glob is I", actualLines.get(0));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForInvalidFilePath() {
        // Arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\test" +
                "\\resources\\InvalidFilePath.png";
        TranslationFileReader reader = new TranslationFileReader();

        // Act & Assert
        assertThrows(IllegalPathExtensionException.class, () -> reader.readFile(filePath));
    }

}