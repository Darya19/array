package com.epam.day4_1.creator;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayCreator {

    public IntArray fillUpRandom() {
        NumberValidator validator = new NumberValidator();
        int count = 0;
        Random random = new Random();
        int number = random.nextInt(10);
        IntArray array = new IntArray(number);
        while (array.size() > array.numberNotNullElements()) {
            number = random.nextInt(1000);
            if (validator.validateNumber(number)) {
                array.set(count, number);
                count++;
            }
        }
        return array;
    }

    public IntArray fillUpFromReader(int... values) {
        NumberValidator validator = new NumberValidator();
        List<Integer> valuesForArray = new ArrayList<>();
        for (int value : values) {
            if (validator.validateNumber(value)) {
                valuesForArray.add(value);
            }
        }
        IntArray array = new IntArray(valuesForArray.size());
        for (int index = 0; index < valuesForArray.size(); index++) {
            array.set(index, valuesForArray.get(index));
        }
        return array;
    }
}
