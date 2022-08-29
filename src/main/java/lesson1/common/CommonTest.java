package lesson1.common;

import java.util.Date;

public class CommonTest {

    public static void main(String[] args) {
//        intTest();
//        stringTest();
        objectTest();
    }

    private static void objectTest() {
        ObjectStorage stringStorage = new ObjectStorage(20);
        stringStorage.add("1df");
        stringStorage.add("sdf2s");
        stringStorage.add("sdfsd3");
        stringStorage.add("dfsd");
        stringStorage.add("efdg");
        stringStorage.add(new Date());

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("2"));
        System.out.println("Find 5: " + stringStorage.find("qqq"));

        String lastValue = (String)stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);


        ObjectStorage intStorage = new ObjectStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);
        stringStorage.add(new Date());

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValueInt = (int)intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValueInt);
    }

    private static void stringTest() {

        StringStorage stringStorage = new StringStorage(20);
        stringStorage.add("1");
        stringStorage.add("2");
        stringStorage.add("3");
        stringStorage.add("d");
        stringStorage.add("efdg");

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("2"));
        System.out.println("Find 5: " + stringStorage.find("qqq"));

        String lastValue = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);
    }

    private static void intTest() {
        IntStorage intStorage = new IntStorage(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValue = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);
    }
}
