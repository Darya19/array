package com.epam.day4_1.validator;

public class NumberValidator {

    private final int maxValue = 1000;
    private final int minValue = 0;

    public boolean validateNumber(int number) {
        return number >= minValue && number < maxValue;
    }
}
