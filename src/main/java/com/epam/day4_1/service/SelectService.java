package com.epam.day4_1.service;

import com.epam.day4_1.entity.IntArray;

public class SelectService {

    public IntArray selectPrimeNumbers(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (primeNumber(array.getElement(i))) {
                count++;
            }
        }
        IntArray primeNumbers = new IntArray(count);
        for (int i = 0; i < array.size(); i++) {
            {
                if (primeNumber(array.getElement(i))) {
                    primeNumbers.add(array.getElement(i));
                }
            }
        }
        return primeNumbers;
    }

    private boolean primeNumber(int number) {
        for (int i = 2; i < (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public IntArray selectFibonacciNumbers(IntArray array) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (isFibonacciNumber(array.getElement(i))) {
                count++;
            }
        }
        IntArray fibonacciArray = new IntArray(count);
        for (int i = 0; i < array.size(); i++) {
            if (isFibonacciNumber(array.getElement(i))) {
                fibonacciArray.add(array.getElement(i));
            }
        }
        return fibonacciArray;
    }

    private boolean isFibonacciNumber(Integer number) {
        if (number == 1) {
            return true;
        }
        int first = 1;
        int second = 1;
        int sumOfFerstAndSeconds = 0;
        while (sumOfFerstAndSeconds < number) {
            sumOfFerstAndSeconds = first + second;
            first = second;
            second = sumOfFerstAndSeconds;
        }
        return (sumOfFerstAndSeconds == number);
    }

    private IntArray findNumbersWithThreeDifferentDigits(IntArray numbers) {
        String number;
        IntArray result = new IntArray();
        for (int i = 0; i < numbers.size() ; i++) {
            number = numbers.getElement(i).toString();
            if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                result.add(Integer.valueOf(number));
            }
        }
        return result;
    }
}
