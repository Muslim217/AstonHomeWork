package aston.task.list;

public interface List<E> {

    void add(E e);

    E get(int index);

    boolean remove(int index);

    int size();

    boolean isEmpty();

}
