package aston.task;

import aston.task.list.List;
import aston.task.list.MyArrayList;



public class Test {
    public static void main(String[] args) {
        List<String> listNull = new MyArrayList<>();
        listNull.add("Q");
        listNull.add("W");
        listNull.add("E");

        System.out.println(listNull.get(1));

        System.out.println(listNull.toString());


    }
}
