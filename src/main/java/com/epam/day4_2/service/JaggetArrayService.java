package com.epam.day4_2.service;

import com.epam.day4_2.exception.ProjectException;
import com.epam.day4_2.typesort.TypeOfSort;

public class JaggetArrayService {

    public int[][] ascendingSort(int[][] array, TypeOfSort sort) throws ProjectException {
        if (array == null) {
            throw new ProjectException("incorrect data");
        }
        for (int i = 0; i < array.length - 1; i++) {
            int value = sort.sort(array[i]);
            int value1 = sort.sort(array[i + 1]);
            if (value > value1) {
                swap(array, i, i + 1);
            }
        }
        return array;
    }

    public int[][] descendingSort(int[][] array, TypeOfSort sort) throws ProjectException {
        if (array == null) {
            throw new ProjectException("incorrect data");
        }
        int[][] reverseArray = ascendingSort(array, sort);
        for (int i = 0; i < reverseArray.length; i++) {
            for (int j = 0; j < reverseArray.length - i - 1; j++) {
                swap(array, j, j + 1);
            }
        }
        return reverseArray;
    }

    private void swap(int[][] array, int firstLine, int secondLine) {
        int[] tmp = array[firstLine];
        array[firstLine] = array[secondLine];
        array[secondLine] = tmp;
    }
}
