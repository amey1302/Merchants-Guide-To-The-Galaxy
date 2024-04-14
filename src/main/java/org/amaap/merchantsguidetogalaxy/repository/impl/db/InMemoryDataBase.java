package org.amaap.merchantsguidetogalaxy.repository.impl.db;

import java.awt.font.ShapeGraphicAttribute;
import java.util.HashMap;

public interface InMemoryDataBase {
    void insert(HashMap<String, String> resultMap);

    HashMap<String ,String> getTransactionRules();
}
