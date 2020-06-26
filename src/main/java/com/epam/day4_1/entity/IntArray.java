package com.epam.day4_1.entity;

import java.util.OptionalInt;

public class IntArray {

    private Integer[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Integer[] EMPTY_ELEMENTS = {};

    public IntArray() {
        this.elements = new Integer[DEFAULT_CAPACITY];
    }

    public IntArray(int capacity) {
        if (capacity > 0) {
            this.elements = new Integer[capacity];
        } else {
            if (capacity == 0) {
                this.elements = EMPTY_ELEMENTS;
            } else {
                this.elements = new Integer[DEFAULT_CAPACITY];
            }
        }
    }

    public boolean add(Integer element) {
        for (int i = 0; i < elements.length; i++) {
            if (this.elements[i] == null) {
                this.elements[i] = element;
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, Integer element) {
        if (index < elements.length && index >= 0) {
            this.elements[index] = element;
            return true;
        } else {
            return false;
        }
    }

    public OptionalInt getElement(int index) {
        if (elements[index] == null || index < elements.length && index >= 0) {
            return OptionalInt.empty();
        }
        if (index < elements.length && index >= 0) {
            return OptionalInt.of(elements[index]);
        }
        return OptionalInt.empty();
    }

    public boolean remove(int index) {
        if (index < elements.length && index >= 0) {
            this.elements[index] = null;
            return true;
        } else {
            return false;
        }
    }

    public int numberNotNullElements() {
        int count = 0;
        for (Integer element : elements) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    public int size() {
        return elements.length;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntArray intArray = (IntArray) o;

        return equalsArray(elements, intArray.elements);
    }

    public boolean equalsArray(Object[] a, Object[] o) {
        if (a == o)
            return true;

        if (o == null || a == null || a.getClass() != o.getClass())
            return false;


        if (a.length != o.length)
            return false;

        for (int i = 0; i < this.size(); i++)
            if (!(a[i] == null ? o[i] == null : a[i].equals(o[i])))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        if (this.elements == null) {
            return 0;
        }
        int result = 1;

        for (Object element : elements) {
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntArray{");
        sb.append("elements= [");
        for (int i = 0; i < elements.length; i++) {
            sb.append(String.valueOf(elements[i]));
            if (i != elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append('}');
        return sb.toString();
    }
}
