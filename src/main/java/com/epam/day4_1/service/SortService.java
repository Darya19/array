package com.epam.day4_1.service;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;

import java.util.Optional;

public class SortService {

    public Optional<IntArray> bubbleSort(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1; j++) {
                if (array.getElement(j).getAsInt() > array.getElement(j + 1).getAsInt()) {
                    swap(array, j, j + 1);
                }
            }
        }
        return Optional.of(array);
    }

    public Optional<IntArray> insertionSort(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        for (int left = 0; left < array.size(); left++) {
            int minIndex = left;
            for (int i = left; i < array.size(); i++) {
                if (array.getElement(minIndex).getAsInt() > array.getElement(i).getAsInt()) {
                    minIndex = i;
                }
            }
            swap(array, left, minIndex);
        }
        return Optional.of(array);
    }

    public Optional<IntArray> shuttleSort(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        for (int i = 1; i < array.size(); i++) {
            if (array.getElement(i).getAsInt() < array.getElement(i - 1).getAsInt()) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array.getElement(z).getAsInt() < array.getElement(z - 1).getAsInt()) {
                        swap(array, z, z - 1);
                    }
                }
            }
        }
        return Optional.of(array);
    }

    private void swap(IntArray array, Integer firstElement, Integer secondElement) {
        int tmp = array.getElement(firstElement).getAsInt();
        array.set(firstElement, array.getElement(secondElement).getAsInt());
        array.set(secondElement, tmp);
    }
}
