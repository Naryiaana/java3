package lesson1.common;

public class StringStorage {

    private String[] data;
    private static final int DEFAULT_SIZE = 10;
    private int currentSize;

    public StringStorage(int size) {
        this.data = new String[size];
        currentSize = 0;
    }

    public StringStorage() {
        this(DEFAULT_SIZE);
    }

    public void add(String value) {
        add(value, currentSize);
    }


    public void add(String value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void display() {
        for (String datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(String value) {
        for (int i = 0; i < currentSize; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                String a = data[i];
                String b = data[j];
                if (a.compareTo(b) > 0) {
                    exchange(i, j);
                }
            }
        }
    }

    private void exchange(int i, int j) {
        String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public String get(int index) {
        return data[index];
    }

    public void removeLast() {
        remove(--currentSize);
    }
}
