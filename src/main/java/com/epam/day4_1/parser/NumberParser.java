package com.epam.day4.task1.parser;

public class NumberParser {

    public int[] parseToInt(String... s) {
        int[] values = null;
        for (int index = 0; index < s.length; index++) {
            int value = Integer.parseInt(s[index]);
            values[index] = value;
        }
        return values;
    }
}
