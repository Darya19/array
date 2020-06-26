package com.epam.day4_1.service;

import com.epam.day4_1.entity.IntArray;
import com.epam.day4_1.exception.CustomException;

import java.util.Optional;

public class SearchService {

    public Optional<Integer> binarySearch(IntArray array, int fromIndex, int toIndex, int key) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        int position;
        while (fromIndex <= toIndex) {
            position = (fromIndex + toIndex) / 2;
            if (array.getElement(position).getAsInt() > key) {
                toIndex = position - 1;
            } else {
                if (array.getElement(position).getAsInt() < key) {
                    fromIndex = position + 1;
                } else return Optional.of(position);
            }
        }
        return Optional.of(-(fromIndex + 1));
    }

    public Optional<Integer> searchMinElement(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        int min = array.getElement(0).getAsInt();
        for (int i = 0; i < array.size(); i++) {
            if (min > array.getElement(i).getAsInt()) {
                min = array.getElement(i).getAsInt();
            }
        }
        return Optional.of(min);
    }

    public Optional<Integer> searchMaxElement(IntArray array) throws CustomException {
        if (array == null) {
            throw new CustomException("array is null");
        }
        if (array.numberNotNullElements() == 0 || array.size() == 0) {
            return Optional.empty();
        }
        int max = array.getElement(0).getAsInt();
        for (int i = 0; i < array.size(); i++) {
            if (max < array.getElement(i).getAsInt()) {
                max = array.getElement(i).getAsInt();
            }
        }
        return Optional.of(max);
    }
}
