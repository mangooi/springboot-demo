package edu.mangooi.structure.data;


public class TimeMulti {
    public int function1(int n) {
        int i = 1;
        int count = 0;
        while (i <= n) {
            i *= 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TimeMulti test1 = new TimeMulti();
        System.out.println(test1.function1(100));
    }
}
