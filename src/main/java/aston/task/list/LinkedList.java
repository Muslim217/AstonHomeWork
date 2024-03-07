package aston.task.list;

public class LinkedList<E> {

    // Внутренний статический класс Node содержит в себе ссылку
    // На следующую ноду и также значение
    private Node<E> head; // Поле head указывает на Первое значение в LL.

    //Метод добавление ноды на вершину LL.* Ll= Linked List
    public void addFirst(E e) {
        Node<E> firstNode = new Node(e);
        firstNode.next = head;
        head = firstNode;

    }

    // Метод добавления в конец LL путем нахождения полсднего элемента
    // у которого в поле next значение null и замены ссылки.
    public void addLast(E e) {
        if (head == null) {
            head = new Node<>(e);
            return;
        }
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(e);


    }

    //Получение индекса ноды в LL
    //Если LL пустой возвращается -1, если нужный элемент является первым, то вернется 0.
    public int get(E e) {
        if (head == null) {
            return -1;
        }
        if (head.value == e)
            return 0;

        Node<E> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            ++result;
            if (currentNode.next.value == e) {
                return result;

            }
            currentNode = currentNode.next;
        }
        return -1;

    }
    // Метод для удаления по значению
    // Метод проходится по LL и после нахождения меняет ссылку у предыдущего на последущего.
    public void remove(E e) {
        if (head == null) {
            return;
        }
        if (head.value == e) {
            head = head.next;
            return;
        }
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == e) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }


    }
    // Возвращает первый элемент
    public E getFirst() {
        return head.value;
    }

    // Возвращает последний элемент проходя вглубь LL
    public E getLast() {
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.value;


    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
    // класс ноды.
    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
