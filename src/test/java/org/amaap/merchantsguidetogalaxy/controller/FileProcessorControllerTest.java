package org.amaap.merchantsguidetogalaxy.controller;

import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.service.FileProcessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileProcessorControllerTest {
    FileProcessorController fileProcessorController;
    FileProcessorService fileProcessorService;

    @BeforeEach
    void setUp() {
        fileProcessorService = new FileProcessorService(new TranslationFileReader(), new TranslationFileParser());
        fileProcessorController = new FileProcessorController(fileProcessorService);
    }

    @Test
    void shouldBeAbleToReadAndParseFile() throws IllegalPathExtensionException, IOException {
        // arrange
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy\\src\\main\\resources" +
                "\\TranslationData.txt";

        // act
        Map<String,String> translationMap = fileProcessorController.readFileAndParse(filePath);

        // assert
        assertEquals("{glob=I, prok=V, pish=X, tegj=L}", translationMap.get("unitMap"));
        assertEquals("{glob glob Silver=34, glob prok Gold=57800, pish pish Iron=3910 }",
                translationMap.get("creditMap"));
        assertEquals("{how much is pish tegj glob glob ?=, how many Credits is glob prok Silver ?=," +
                        " how many Credits is glob prok Gold ?=, how many Credits is glob prok Iron ?=}",
                translationMap.get("questionMap"));
    }

}