package edu.mangooi.structure.data;


import java.util.Arrays;

public class ArrayDemo<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] value;
    private int count;
    private int curCapacity;

    public ArrayDemo(int size) {
        value = new Object[size];
        curCapacity = size;
        count = 0;
    }

    public synchronized boolean add(Object o) {
        checkCapacity(count + 1);
        value[count++] = o;
        return false;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object o : value) {
            builder.append(o);
        }
        return builder.toString();
    }

    private void checkCapacity(int value) {
        if (value > curCapacity) {
            this.curCapacity += DEFAULT_CAPACITY;
            this.value = Arrays.copyOf(this.value, curCapacity + DEFAULT_CAPACITY);
        }
    }

    @SuppressWarnings("unchecked")
    private T getByIndex(int index) {
        return (T) value[index];
    }

    public static void main(String[] args) {
        ArrayDemo<String> test = new ArrayDemo<>(10);
        System.out.println(test);
    }
}
