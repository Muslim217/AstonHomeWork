package aston.task.list;

import java.util.Arrays;

public class ArrayListImp implements List {


    private static int defaultSize = 10;
    private int size;
    private Object[] massive;
    private int count = 0;

    public ArrayListImp(int size) {
        this.size = size;
        massive = new Object[size];
    }

    public ArrayListImp() {
        size = defaultSize;
        massive = new Object[size];
    }


    @Override
    public void add(Object o) {
        if (massive.length <= count) {
            Object[] newMassive = new Object[size = size * 2];
            System.arraycopy(massive, 0, newMassive, 0, massive.length);
            massive = newMassive;
            massive[count] = o;
            count++;
        } else if (massive.length > count) {
            massive[count] = o;
            count++;

        }

    }
    @Override
    public Object get(int index) {
        return massive[index];
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= massive.length) {
            return false; //если индекс не корректный, вернем исходный массив без изменений
        }
        size--;
        count--;
        Object[] result = new Object[massive.length - 1];
        for (int i = 0, j = 0; i < massive.length; i++) {
            if (i != index) {
                result[j++] = massive[i];
            }
        }
        massive = result;
        return true;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(massive);
    }
}
