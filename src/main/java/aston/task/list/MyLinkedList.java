package aston.task.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<E> implements List<E>, Deque<E>, Iterable<E> {
    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public boolean addFirst(E e) {
        Node<E> firstNode = new Node<>(e);
        if (size == 0) {
            head = firstNode;
            tail = firstNode;
            size++;
            return true;
        } else {
            firstNode.next = head;
            head.previous = firstNode;
            head = firstNode;
            size++;
            return true;

        }


    }



    @Override
    public boolean addLast(E e) {
        Node<E> lastNode = new Node<>(e);
        if (size == 0) {
            head = lastNode;
            tail = lastNode;
            size++;
            return true;
        } else {
            tail.next = lastNode;
            lastNode.previous = tail;
            tail = lastNode;
            size++;
            return true;
        }

    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean add(E e, int index) {
        if (index > size) {
            return false;
        }
        if (index == size) {
            addLast(e);
            return true;
        }
        if (index == 0) {
            addFirst(e);
            return true;
        } else {
            Node<E> currentNode = head;
            int counter = 0;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
            Node<E> newNode = new Node(e);
            Node<E> prevCurrentNode = currentNode.previous;
            currentNode.previous = newNode;
            newNode.next = currentNode;
            prevCurrentNode.next = newNode;
            size++;
            return true;
        }

    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        } else {
            Node<E> currentNode = head;
            int counter = 0;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
            return (E) currentNode.value;
        }


    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            Node<E> newHead = head.next;
            newHead.previous = null;
            head = newHead;
            size--;
            return true;
        }
        if (index == size - 1) {
            Node<E> prevNew = tail.previous;
            prevNew.next = null;
            tail = prevNew;
            size--;
            return true;
        } else {
            Node<E> currentNode = head;
            int counter = 0;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
            Node<E> prevCurrentNode = currentNode.previous;
            Node<E> nextCurrentNode = currentNode.next;
            prevCurrentNode.next = nextCurrentNode;
            nextCurrentNode.previous = prevCurrentNode;
            size--;

            return true;


        }


    }

    @Override
    public boolean removeAll() {
        head = null;
        tail = null;
        size = 0;
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
    public void sort(Comparator comparator) {
        Node node = head;
        Object[] data = new Object[size];
        int counter = 0;
        while (size != counter) {
            data[counter] = node.value;
            node = node.next;
            counter++;
        }
        if (comparator == null) {
            Arrays.sort(data, 0, data.length, null);
        } else
            Arrays.sort(data, 0, data.length, comparator);
        removeAll();
        for (int i = 0; i < data.length; i++) {
            add((E) data[i]);

        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        var cur = head;
        while (cur != null) {
            result.append(cur).append(" ");
            cur = cur.next;
        }
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size - 1;
            }

            @Override
            public E next() {
                return get(counter++);
            }
        };
    }


    private static class Node<E> {
        private E value;
        private MyLinkedList.Node<E> next;
        private MyLinkedList.Node<E> previous;

        public Node(E value) {
            this.value = value;

        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }
}
