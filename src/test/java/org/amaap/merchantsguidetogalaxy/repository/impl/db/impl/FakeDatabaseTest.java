package org.amaap.merchantsguidetogalaxy.repository.impl.db.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeDatabaseTest {
    private FakeDatabase fakeDatabase;

    @BeforeEach
    void setUp() {
        fakeDatabase = new FakeDatabase();
    }

    @Test
    void shouldBeAbleToInsertDataIntoDatabase() {
        // arrange
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("unitMap", "{glob=I, prok=V}");
        resultMap.put("creditsMap", "{Silver=34, Gold=57800}");
        resultMap.put("questionMap", "{how many Credits is glob prok Silver ?=}");

        // Act
        fakeDatabase.insert(resultMap);

        // assert
        assertEquals("{glob=I, prok=V}", fakeDatabase.getTransactionRules().get("unitMap"));
        assertEquals("{Silver=34, Gold=57800}", fakeDatabase.getTransactionRules().get("creditsMap"));
        assertEquals("{how many Credits is glob prok Silver ?=}", fakeDatabase.getTransactionRules().get("questionMap"));
    }
}
