package lesson1.generics;

import java.util.Date;

public class GenericTest {

    public static void main(String[] args) {
        GenericStorage<Date> dateStorage = new GenericStorage<>(20);

//        GenericStorage<IntStorage> intStorageStorage = new GenericStorage<>(20);

        GenericStorage<String> stringStorage = new GenericStorage<>(20);
        stringStorage.add("1df");
        stringStorage.add("sdf2s");
        stringStorage.add("sdfsd3");
        stringStorage.add("dfsd");
        stringStorage.add("efdg");
//        stringStorage.add(new Date());

        stringStorage.display();

        System.out.println("Find 2: " + stringStorage.find("2"));
        System.out.println("Find 5: " + stringStorage.find("qqq"));

        String lastValue = stringStorage.get(stringStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValue);


        GenericStorage<Integer> intStorage = new GenericStorage<>(20);
        intStorage.add(1);
        intStorage.add(2);
        intStorage.add(3);
        intStorage.add(0);
        intStorage.add(0);
//        intStorage.add(new Date());

        intStorage.display();

        System.out.println("Find 2: " + intStorage.find(2));
        System.out.println("Find 5: " + intStorage.find(5));

        int lastValueInt = intStorage.get(intStorage.getCurrentSize() - 1);
        System.out.println("Last value: " + lastValueInt);
    }
}
