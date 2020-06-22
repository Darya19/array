package com.epam.day4.task1.validator;

public class NumberValidator {

    private final int MAX_VALUE = Integer.MAX_VALUE;
    private final int MIN_VALUE = Integer.MIN_VALUE;

    public boolean validateNumber(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }
}
