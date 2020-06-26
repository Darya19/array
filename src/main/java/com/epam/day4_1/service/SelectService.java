package com.epam.day4_1.service;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;

import java.util.Optional;

public class SelectService {

    public Optional<IntArray> selectPrimeNumbers(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        for (int i = 0; i < array.size(); i++) {
            if (!primeNumber(array.getElement(i).getAsInt())) {
                array.remove(i);
            }
        }
        IntArray primeNumbers = new IntArray(array.numberNotNullElements());
        for (int i = 0; i < array.size(); i++) {
            if (array.getElement(i).isPresent()) {
                primeNumbers.add(array.getElement(i).getAsInt());
            }
        }
        return Optional.of(primeNumbers);
    }

    private boolean primeNumber(int number) {
        for (int i = 2; i < (number / 2); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Optional<IntArray> selectFibonacciNumbers(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        for (int i = 0; i < array.size(); i++) {
            if (!isFibonacciNumber(array.getElement(i).getAsInt())) {
                array.remove(i);
            }
        }
        IntArray fibonacciArray = new IntArray(array.numberNotNullElements());
        for (int i = 0; i < array.size(); i++) {
            if (array.getElement(i).isPresent()) {
                fibonacciArray.add(array.getElement(i).getAsInt());
            }
        }
        return Optional.of(fibonacciArray);
    }

    private boolean isFibonacciNumber(Integer number) {
        int sumOfFirstAndSeconds = 2;
        int first = 1;
        int second = 1;
        if (number == 1 || number == 2) {
            return true;
        } else {
            while (sumOfFirstAndSeconds < number) {
                first = second;
                second = sumOfFirstAndSeconds;
                sumOfFirstAndSeconds = first + second;
            }
        }
        return (sumOfFirstAndSeconds == number);
    }

    public Optional<IntArray> findNumbersWithThreeDifferentDigits(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        String number;
        for (int i = 0; i < array.size(); i++) {
            number = String.valueOf(array.getElement(i).getAsInt());
            if (number.length() == 3) {
                if (number.charAt(0) == number.charAt(1)
                        || number.charAt(1) == number.charAt(2)
                        || number.charAt(0) == number.charAt(2)) {
                    array.remove(i);
                }
            } else {
                array.remove(i);
            }
        }
        IntArray result = new IntArray(array.numberNotNullElements());
        for (int i = 0; i < array.size(); i++) {
            if (array.getElement(i).isPresent()) {
                result.add(array.getElement(i).getAsInt());
            }
        }
        return Optional.of(result);
    }
}
