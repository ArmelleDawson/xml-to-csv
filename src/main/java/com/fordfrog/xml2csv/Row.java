package com.fordfrog.xml2csv;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Row {

    private final boolean shouldTrim;
    private final List<String> values;

    public Row(boolean shouldTrim, int numberOfColumns) {
        this.shouldTrim = shouldTrim;
        this.values = initialiseValues(numberOfColumns);
    }

    public void join(int index, String value) {
        StringBuilder joined = new StringBuilder(values.get(index));
        if (!StringUtils.isEmpty(joined.toString()))
            joined.append(",");
        joined.append(value);
        values.set(index, joined.toString());
    }

    public void append(int index, String value) {
        String appendedValue = values.get(index);
        appendedValue += value;
        values.set(index, appendedValue);
    }

    public List<String> getValues() {
        if (shouldTrim)
            return getTrimmedValues();
        return getRawValues();
    }

    private List<String> getTrimmedValues() {
        List<String> trimmed = new ArrayList<>(values.size());
        for (String value  : values)
            trimmed.add(value.trim());
        return trimmed;
    }

    private List<String> getRawValues() {
        return new ArrayList<>(values);
    }

    private static List<String> initialiseValues(int numberOfColumns) {
        List<String> values = Arrays.asList(new String[numberOfColumns]);
        for (int i = 0; i < numberOfColumns; i++)
            values.set(i, "");
        return values;
    }

}
