package com.epam.day4_1.service;

import com.epam.day4_1.entity.IntArray;

public class SearchService {

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

    public int searchMinElement(IntArray array) {
        int min = array.getElement(0);
        for (int i = 0; i < array.size(); i++) {
            if(min > array.getElement(i)) {
                min = array.getElement(i);
            }
        }
        return min;
    }

    public int searchMaxElement(IntArray array) {
        int max = array.getElement(0);
        for (int i = 0; i < array.size(); i++) {
            if(max < array.getElement(i)) {
                max = array.getElement(i);
            }
        }
        return max;
    }
}
