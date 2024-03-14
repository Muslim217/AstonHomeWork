package aston.task.list;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> implements List<E> {
    private final int defaultSize = 10;

    private int size;

    private E[] data;

    public MyArrayList() {
        data = (E[]) new Object[defaultSize];
    }

    @Override
    public boolean add(E e) {
        if (size > data.length - 1) {
            E[] newData = (E[]) new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            newData[size] = e;
            data = newData;
            size++;
            return true;
        } else if (size <= data.length - 1) {
            data[size] = e;
            size++;
            return true;
        }
        return false;
    }


    @Override
    public E get(int index) {
        if (index <= data.length - 1 && size > 0) {
            return data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= data.length) {
            return false;
        } else {
            size--;
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            return true;
        }


    }

    @Override
    public boolean removeAll() {
        data = (E[]) new Object[defaultSize];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void sort(Comparator comparator) {
        if (comparator == null) {
            Arrays.sort(data, 0, size, null);
        } else
            Arrays.sort(data, 0, size, comparator);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

}

