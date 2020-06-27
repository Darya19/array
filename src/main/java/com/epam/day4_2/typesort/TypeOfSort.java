package com.epam.day4_2.typesort;

public enum TypeOfSort {

    SUM_ELEMENTS {
        public int sort(int[] arrayLine) {
            int sum = 0;
            for (int i = 0; i < arrayLine.length; i++) {
                sum += arrayLine[i];
            }
            return sum;
        }
    },
    MIN_ELEMENT {
        public int sort(int[] arrayLine) {
            int min = arrayLine[0];
            for (int i = 0; i < arrayLine.length; i++) {
                if (min > arrayLine[i]) {
                    min = arrayLine[i];
                }
            }
            return min;
        }
    },
    MAX_ELEMENT {
        public int sort(int[] arrayLine) {
            int min = arrayLine[0];
            for (int i = 0; i < arrayLine.length; i++) {
                if (min < arrayLine[i]) {
                    min = arrayLine[i];
                }
            }
            return min;
        }
    };

    public abstract int sort(int[] array);
}
