package cn.helloworld1999;

import java.util.Arrays;

public class MyArrayList {
    private Object[] eleArray;
    private int size = 0;

    public MyArrayList() {
        eleArray = new Object[10];
    }

    public void add(int index, Object element) {
        if (size == eleArray.length) {
            eleArray = Arrays.copyOf(eleArray, size * 2);
        }
        eleArray[index] = element;
    }

    public void remove(int index) {
        if (size <= 0 || index >= size || index < 0) {
            throw new RuntimeException("没东西可删");
        }
        System.arraycopy(eleArray, index + 1, eleArray, index, size - index - 1);
        eleArray[--size] = null;
    }

    public Object get(int index) {
        if (size <= 0 || index >= size || index < 0) {
            throw new RuntimeException("没东西可拿");
        }
        return eleArray[index];
    }

    public void set(int index, Object element) {
        if (size <= 0 || index >= size || index < 0) {
            throw new RuntimeException("没东西可改");
        }
        eleArray[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int index, Object element) {
        if (size == eleArray.length) {
            eleArray = Arrays.copyOf(eleArray, size * 2);
        }
        System.arraycopy(eleArray, index, eleArray, index + 1, size - index);
        eleArray[index] = element;
        size ++;
    }

}
