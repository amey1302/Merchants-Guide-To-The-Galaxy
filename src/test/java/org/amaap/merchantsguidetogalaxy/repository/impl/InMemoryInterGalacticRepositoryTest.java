package org.amaap.merchantsguidetogalaxy.repository.impl;

import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryInterGalacticRepositoryTest {
    private InMemoryInterGalacticRepository repository;
    private InMemoryDataBase fakeDatabase;

    @BeforeEach
    void setUp() {
        fakeDatabase = new FakeDatabase();
        repository = new InMemoryInterGalacticRepository(fakeDatabase);
    }

    @Test
    void shouldBeAbleToInsertDataIntoRepository() {
        // arrange
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("unitMap", "{glob=I, prok=V}");
        resultMap.put("creditsMap", "{Silver=34, Gold=57800}");
        resultMap.put("questionMap", "{how many Credits is glob prok Silver ?=}");

        // Act
        repository.insert(resultMap);

        // assert
        assertEquals("{glob=I, prok=V}", repository.getDataFromFile().get("unitMap"));
        assertEquals("{Silver=34, Gold=57800}", repository.getDataFromFile().get("creditsMap"));
        assertEquals("{how many Credits is glob prok Silver ?=}", repository.getDataFromFile().get("questionMap"));
    }
}
