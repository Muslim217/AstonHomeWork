import aston.task.list.Deque;
import aston.task.list.List;
import aston.task.list.MyArrayList;
import aston.task.list.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {


    @Test
    void sizeTest() {
        List<Integer> testList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        Assertions.assertEquals(testList.size(), 10);

    }

    @Test
    void addTest() {
        List<String> testList = new MyLinkedList<>();
        testList.add("One");
        testList.add("Two");
        Assertions.assertEquals(testList.size(), 2);
    }

    @Test
    void getTest() {
        List<Integer> testList = new MyLinkedList<>();
        for (int i = 0; i <= 20; i++) {
            testList.add(i);
        }
        Assertions.assertEquals(testList.size(), 21);
        Assertions.assertEquals(testList.get(20), 20);

    }

    @Test
    void removeTest() {
        List<String> testList = new MyLinkedList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.remove(1);
        Assertions.assertEquals(testList.size(), 2);
    }

    @Test
    void removeAllTest() {
        List<String> testList = new MyLinkedList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.removeAll();
        Assertions.assertEquals(testList.size(), 0);
    }

    @Test
    void isEmptyTest() {
        List<String> testList = new MyLinkedList<>();
        testList.add("One");
        testList.add("Two");
        testList.add("Three");
        testList.removeAll();
        Assertions.assertEquals(testList.size(), 0);


    }

    @Test
    void testSort() {
        List testList = new MyLinkedList();
        testList.add(5);
        testList.add(2);
        testList.add(1);
        testList.add(3);
        testList.add(4);
        testList.sort(null);
        Assertions.assertEquals(1, testList.get(0));
        Assertions.assertEquals(2, testList.get(1));
        Assertions.assertEquals(3, testList.get(2));
        Assertions.assertEquals(4, testList.get(3));
        Assertions.assertEquals(5, testList.get(4));

    }




}

