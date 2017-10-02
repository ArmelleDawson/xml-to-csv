package com.fordfrog.xml2csv;

import java.util.Arrays;
import java.util.Map;

public class AttributesConfig implements ConversionConfig {

    @Override
    public Map<String, Integer> getColumns() {
        return ColumnsConverter.toMap(Arrays.asList("value[@type='user']","value[@type='customer']"));
    }

    @Override
    public String getSeparator() {
        return SEMI_COLON;
    }

    @Override
    public boolean shouldTrim() {
        return false;
    }

    @Override
    public boolean shouldJoin() {
        return false;
    }

    @Override
    public String getRowItemName() {
        return "/root/item";
    }

}
