package aston.task.list;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayList implements List {

    //Изначальный размер внутреннего массива
    private static final int defaultSize = 1;

    //Длина массива
    private int size = defaultSize;

    //Основа динамического массива-стандартный массив
    private Object[] data;

    //Подсчёт количества изменений
    private int modCount = 0;

    //Конструктор с параметром принимающий на вход массив
    public ArrayList(Object[] e) {
        data = e;

    }

    //Конструктор без параметра и с указанием дефолтного значения для длины.
    public ArrayList() {
        data = new Object[size];

    }

    //  Метод добавления элемента в список
    @Override
    public void add(Object o) {
        if (modCount >= data.length) {
            Object[] newMassive = new Object[size = size + 1];
            System.arraycopy(data, 0, newMassive, 0, data.length);
            data = newMassive;
            data[modCount] = o;
            modCount++;
        }
        if (modCount < data.length) {
            data[modCount] = o;
            modCount++;

        }

    }
    //Добавление в массив по индексу
    @Override
    public void addToIndex(Object o, int index) {
        if (index < size - 1) {
            data[index] = o;
        }
    }
    // Удаление элементов из массива
    @Override
    public boolean removeAll() {
        data = new Object[defaultSize];
        return true;
    }

    // Получение по индексу
    // Если значения индекса не входит в промежуток в массиве, то возвращается null
    @Override
    public Object get(int index) {
        if (index <= data.length) {
            return data[index];
        } else return null;
    }


    //Метод удаления по индексу. После удаления элемента, элементы из право части смещаются влево
    // и перезаписываются в новый массив с количеством элементов -1
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= data.length) {
            return false; //если индекс не корректный, вернем исходный массив без изменений
        }
        modCount--;
        size = modCount;
        Object[] result = new Object[size];
        for (int i = 0, j = 0; i < data.length; i++) {
            if (i != index) {
                result[j++] = data[i];
            }
        }
        data = result;
        return true;

    }

    // Возвращает размер
    @Override
    public int size() {
        return size;
    }
    // Проверка на пустоту массива
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод сортировки принимает функциональный интерфейс в параметр и сортирует исходя из Comparator
    // Если передать в параметр null, то сортировка произойдет по порядку.
    @Override
    public void sort(Comparator c) {
        if (c == null) {
            Arrays.sort(data, 0, size, null);
        } else
            Arrays.sort(data, 0, size, c);
    }

    //Превращение массива в строку
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
