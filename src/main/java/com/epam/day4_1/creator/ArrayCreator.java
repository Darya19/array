package com.epam.day4.task1.creator;

import com.epam.day4.task1.entity.IntArray;
import com.epam.day4.task1.validator.NumberValidator;

import java.util.Random;

public class ArrayCreator {

    private IntArray array;

    public IntArray fillUpRandom() {
        NumberValidator validator = new NumberValidator();
        int number = 0;
        int count = 0;
        array = new IntArray();//TODO is capacity necessary or use default capacity?
        Random random = new Random();
       while(array.size() != array.fullSize()) {
            number = random.nextInt();
            if (validator.validateNumber(number)) {
                array.set(count, number);
            }
        }
        return array;
    }

    public IntArray fillUpFromReader(int... values) {
        NumberValidator validator = new NumberValidator();
        array = new IntArray(values[0]); //TODO can use first number as a capacity?
        for (int index = 1; index < values.length; index++) {
            if (validator.validateNumber(values[index])) {
                array.set(index, values[index]);
            } else {
                index++;
            }
        }
        return array;
    }
}
