package aston.task;


import aston.task.list.ArrayList;
import aston.task.list.LinkedList;
import aston.task.list.List;


public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.addFirst(1);
        integerLinkedList.addLast(2);
        integerLinkedList.addLast(3);
        integerLinkedList.addLast(4);
        integerLinkedList.addLast(5);
        System.out.println(integerLinkedList);
        System.out.println(integerLinkedList.getFirst());
        System.out.println(integerLinkedList.getLast());
        integerLinkedList.remove(4);
        System.out.println(integerLinkedList);



    }
}
