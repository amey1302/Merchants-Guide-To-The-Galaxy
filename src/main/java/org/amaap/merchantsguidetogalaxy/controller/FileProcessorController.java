package org.amaap.merchantsguidetogalaxy.controller;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.service.FileProcessorService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileProcessorController {
    private FileProcessorService fileProcessorService;

    @Inject
    public FileProcessorController(FileProcessorService fileProcessorService) {
        this.fileProcessorService = fileProcessorService;
    }

    public Map<String, String> readFileAndParse(String filePath) throws IllegalPathExtensionException, IOException {
        return fileProcessorService.readFileAndParse(filePath);

    }


}
