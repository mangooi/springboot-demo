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

    public int getSize() {
        return count;
    }


    public boolean isEmpty() {
        return count == 0;
    }

    public boolean add(Object o) {
        checkCapacity(count + 1);
        value[count++] = o;
        return false;
    }

    public T get(int index) {
        checkRange(index);
        return getByIndex(index);
    }


    private void checkRange(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public String toString() {
        if (count == 0) return "";
        int count = this.count;
        Object[] value = this.value;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(i == count - 1 ? value[i] : value[i] + ",");
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
        test.add("abc");
        test.add("cdferaa");
        System.out.println(test);
        System.out.println(test.get(0));
    }
}
