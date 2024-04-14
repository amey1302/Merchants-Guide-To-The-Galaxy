package org.amaap.merchantsguidetogalaxy.IO;

import org.amaap.merchantsguidetogalaxy.domain.model.RomanToNumeral;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TranslationFileParser {
    public HashMap<String, String> parse(List<String> lines) {
        HashMap<String, String> unitMap = new LinkedHashMap<>();
        HashMap<String, String> creditMap = new LinkedHashMap<>();
        HashMap<String, String> questionMap = new LinkedHashMap<>();

        for (String line : lines) {
            String[] parts = line.split(" is ");
            if (parts.length == 2) {
                String unit = parts[0].trim();
                String value = parts[1].trim();
                if (value.endsWith("Credits")) {
                    value = value.replace("Credits","");
                    creditMap.put(unit, value);
                } else if (value.endsWith("?")) {
                    questionMap.put(line, "");
                } else {
                    if (isRomanNumeral(value)) {
                        unitMap.put(unit, value);
                    }
                }
            }
        }
        HashMap<String, String> resultMap = new LinkedHashMap<>();
        resultMap.put("unitMap", unitMap.toString().replaceAll("\\s+,\\s+", ", "));
        resultMap.put("creditMap", creditMap.toString().replaceAll("\\s+,\\s+", ", "));
        resultMap.put("questionMap", questionMap.toString().replaceAll("\\s+,\\s+", ", "));
        return resultMap;
    }
    private boolean isRomanNumeral(String word) {
        for (RomanToNumeral numeral : RomanToNumeral.values()) {
            if (numeral.name().equals(word)) {
                return true;
            }
        }
        return false;
    }

}

