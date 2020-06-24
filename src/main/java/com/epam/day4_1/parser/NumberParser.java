package com.epam.day4_1.parser;

import com.epam.day4_1.exception.CustomException;

public class NumberParser {

    public Integer[] parseToInt(String... stringNumbers) throws CustomException {
        Integer[] values = new Integer[stringNumbers.length];
        try {
            for (int index = 0; index < stringNumbers.length; index++) {
                int value = Integer.parseInt(stringNumbers[index]);
                values[index] = value;
            }
            return values;
        } catch (NumberFormatException e) {
            throw new CustomException("parsing issues", e);
        }
    }
}
