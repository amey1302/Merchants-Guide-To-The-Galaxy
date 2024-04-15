package org.amaap.merchantsguidetogalaxy.repository.impl;

import jakarta.inject.Inject;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;

import java.util.HashMap;

public class InMemoryInterGalacticRepository implements InterGalacticRepository {
    private InMemoryDataBase inMemoryDataBase;

    @Inject
    public InMemoryInterGalacticRepository(InMemoryDataBase inMemoryDataBase) {
        this.inMemoryDataBase = inMemoryDataBase;
    }
    @Override
    public void insert(HashMap<String, String> resultMap) {
        inMemoryDataBase.insert(resultMap);
    }

    @Override
    public HashMap<String, String> getDataFromFile() {
        return inMemoryDataBase.getTransactionRules();
    }


}
