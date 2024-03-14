import aston.task.list.List;
import aston.task.list.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class ArrayListTest {


    @Test
    void sizeTest() {
        List<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        Assertions.assertEquals(testList.size(), 10);

    }

    @Test
    void addTest() {
        List<String> testList = new MyArrayList<>();
        testList.add("One");
        testList.add("Two");
        Assertions.assertEquals(testList.size(), 2);
    }

    @Test
    void getTest() {
        List<Integer> testList = new MyArrayList<>();
        for (int i = 0; i <= 20; i++) {
            testList.add(i);
        }
        Assertions.assertEquals(testList.size(), 21);
        Assertions.assertEquals(testList.get(20), 20);

    }

    @Test
    void removeTest() {
        List<String> testList = new MyArrayList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.remove(1);
        Assertions.assertEquals(testList.size(), 2);
    }

    @Test
    void removeAllTest() {
        List<String> testList = new MyArrayList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.removeAll();
        Assertions.assertEquals(testList.size(), 0);
    }

    @Test
    void isEmptyTest() {
        List<String> testList = new MyArrayList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.removeAll();
        Assertions.assertEquals(testList.size(), 0);


    }

    @Test
    void testSort() {
        List myArrayList = new MyArrayList<>();
        myArrayList.add(5);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.sort(null);
        Assertions.assertEquals(1, myArrayList.get(0));
        Assertions.assertEquals(2, myArrayList.get(1));
        Assertions.assertEquals(3, myArrayList.get(2));
        Assertions.assertEquals(4, myArrayList.get(3));
        Assertions.assertEquals(5, myArrayList.get(4));

    }


}

