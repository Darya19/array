package com.epam.day4.task1.entity;

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
        } else if (capacity == 0) {
            this.elements = EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);//TODO can use unchecked exp here?
        }
    }

    public boolean set(int index, Integer element) {
        if (index < elements.length) {
            this.elements[index] = element;
            return true;
        } else {
            return false;
        }
    }

    public Integer getElement(int index) {
        if (index < elements.length) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("index out Of bounds");//TODO can use unchecked exp here?
        }
    }

    public boolean remove(int index) {
        if (index < elements.length) {
            this.elements[index] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Integer element) {
        if (element == null) {
            for (int index = 0; index < elements.length; index++)
                if (elements[index] == null) {
                    return true;
                }
        } else {
            for (int index = 0; index < elements.length; index++) {
                if ((element.equals(elements[index]))) {
                    elements[index] = null;
                    return true;
                }
            }
        }
        return false;
    }

    // actual number Of not null elements in array
    public int size() {
        int count = 0;
        for (Integer element : elements) {
            if (element != null) {
                count++;
            }
        }
        return count;
    }

    // size of array include null elements
    public int fullSize() {
        return elements.length;
    }

    public boolean equals(Object[] o) { //TODO Can create equals without override?
        if (this.elements == o) return true;
        if (o == null || elements.getClass() != o.getClass()) return false;

        if (elements.length != o.length) return false;
        for (int i = 0; i < this.size(); i++) {
            if (this.elements[i] != o[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.elements == null)
            return 0;

        int result = 1;

        for (Object element : elements)
            result = 31 * result + (element == null ? 0 : element.hashCode());

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
            } else {
                sb.append("]");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
