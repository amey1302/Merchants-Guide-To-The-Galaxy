package org.amaap.merchantsguidetogalaxy.repository.impl.db.impl;

import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FakeDatabase implements InMemoryDataBase {
    private HashMap<String ,String> translationRules = new LinkedHashMap<>();
    @Override
    public void insert(HashMap<String, String> resultMap) {
      translationRules.put("unitMap",resultMap.get("unitMap"));
      translationRules.put("creditsMap",resultMap.get("creditsMap"));
      translationRules.put("questionMap",resultMap.get("questionMap"));
    }

    @Override
    public HashMap<String, String> getTransactionRules() {
        return translationRules;
    }


}
