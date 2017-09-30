package com.fordfrog.xml2csv;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ColumnsConverter {

    public static Map<String, Integer> toMap(List<String> columns) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < columns.size(); i++)
            map.put(columns.get(i), i);
        return map;
    }

}
