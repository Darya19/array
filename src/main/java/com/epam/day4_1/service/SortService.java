package com.epam.day4_1.service;


import com.epam.day4_1.entity.IntArray;

public class SortService {

    public IntArray bubbleSort(IntArray array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size(); j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    int tmp = array.getElement(j);
                    array.set(j, array.getElement(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
        return array;
    }

    public IntArray insertionSort(IntArray array) {
        for (int left = 1; left < array.size(); left++) {
            int value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getElement(i)) {
                    array.set(i + 1, array.getElement(i));
                }
                array.set(i + 1, value);
            }
        }
        return array;
    }

    public IntArray shuttleSort(IntArray array) {
        for (int i = 1; i < array.size(); i++) {
            if (array.getElement(i) < array.getElement(i - 1)) {
                int tmp = array.getElement(i);
                array.set(i, array.getElement(i - 1));
                array.set(i - 1, tmp);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array.getElement(z) < array.getElement(z - 1)) {
                        int temp = array.getElement(z);
                        array.set(z, array.getElement(z - 1));
                        array.set(z - 1, temp);
                    }
                }
            }
        }
        return array;
    }
}
