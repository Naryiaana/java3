package lesson1.common;

public class ObjectStorage {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int currentSize;

    public ObjectStorage(int size) {
        this.data = new Object[size];
        currentSize = 0;
    }

    public ObjectStorage() {
        this(DEFAULT_SIZE);
    }

    public void add(Object value) {
        add(value, currentSize);
    }


    public void add(Object value, int index) {
        data[index] = value;
        currentSize++;
    }

    public void display() {
        for (Object datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public void remove(int index) {
        data[index] = null;
        currentSize--;
    }

    public boolean find(Object value) {
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
                Comparable a = (Comparable)data[i];
                Comparable b = (Comparable)data[j];
                if (a.compareTo(b) > 0) {
                    exchange(i, j);
                }
            }
        }
    }

    private void exchange(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Object get(int index) {
        return data[index];
    }

    public void removeLast() {
        remove(--currentSize);
    }
}
