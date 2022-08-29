package lesson1.homework;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        System.out.println("Первое задание: ");
        first();
        System.out.println("Второе задание: ");
        second();
        System.out.println("Третье задание: ");
        third();
    }

    public static void first() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        String toMoveUp = "4";
        while (list.indexOf(toMoveUp) != 0) {
            int i = list.indexOf(toMoveUp);
            Collections.swap(list, i, i - 1);
        }

        System.out.println(list);
    }

    public static void second() {
        Integer[] mass = {1, 2, 4, 56, 7};
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }

        List<Integer> intToList;
        intToList = Arrays.asList(mass);

        System.out.println("ArrayList: " + intToList);
    }

    public static void third() {

        Box<Apple> boxApple = new Box<>(new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple());
        Box<Orange> boxOrange = new Box<>(new Orange());
        Box<Orange> secondOrangeBox = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.println("Вес коробки с яблоками составляет " + boxApple.getWeight());
        System.out.println("Вес первой коробки с апельсинами составляет " + boxOrange.getWeight());
        System.out.println("Вес второй коробки с апельсинами составляет " + secondOrangeBox.getWeight());

        System.out.println("Пересыпаем апельсины");

        boxOrange.replaceFruits(secondOrangeBox);
        System.out.println("Вес первой коробки с апельсинами составляет " + boxOrange.getWeight());
        System.out.println("Вес второй коробки с апельсинами составляет " + secondOrangeBox.getWeight());

        System.out.println("Сравниваем веса коробок: ");


        System.out.println("Равен ли вес коробки с яблоками и первой коробки с апельсинами: " + boxApple.compare(boxOrange));
        System.out.println("Равен ли вес коробки с яблоками и второй коробки с апельсинами: " + boxApple.compare(secondOrangeBox));
    }
}