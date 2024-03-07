package aston.task.list;

import java.util.Comparator;

public interface List<E> {

    void add(E e);

    void addToIndex(E e,int index);

    E get(int index);

    boolean remove(int index);

    boolean removeAll();

    int size();

    boolean isEmpty();

    void sort(Comparator<E> comparator);

}
