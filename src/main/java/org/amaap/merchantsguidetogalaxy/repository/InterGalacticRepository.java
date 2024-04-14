package org.amaap.merchantsguidetogalaxy.repository;

import java.util.HashMap;

public interface InterGalacticRepository {
    void insert(HashMap<String, String> resultMap);
    HashMap<String,String> getDataFromFile();
}
