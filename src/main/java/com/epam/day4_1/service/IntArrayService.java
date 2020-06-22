package com.epam.day4.task1.service;

import com.epam.day4.task1.entity.IntArray;

public class IntArrayService {

    public IntArray bubbleSort(IntArray array) {
        for (int i = 0; i < array.fullSize() - 1; i++) {
            for (int j = 0; j < array.fullSize(); j++) {
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
        for (int left = 1; left < array.fullSize(); left++) {
            int value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getElement(i)) {
                    array.set(i + 1, array.getElement(i));
                } else {
                    break;
                }
            }
            array.set(i + 1, value);
        }
        return array;
    }

    public IntArray shuttleSort(IntArray array) {
        for (int i = 1; i < array.fullSize(); i++) {
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

    public int binarySearch(IntArray array, int fromIndex, int toIndex, int key) {
        int position;
        while (fromIndex <= toIndex) {
            position = (fromIndex + toIndex) / 2;
            if (array.getElement(position) > key) {
                toIndex = position - 1;
            } else {
                if (array.getElement(position) < key) {
                    fromIndex = position + 1;
                } else return position;
            }
        }
        return -(fromIndex + 1);
    }
}
