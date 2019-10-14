package club.mangooi.springboot.demo.utils.test;

import java.util.Iterator;
import java.util.logging.SimpleFormatter;

public class StringDemo {
    public static void main(String[] args) {
        // CodePointAt()
        System.out.println("aceg".codePointAt(0));
        System.out.println("aceg".codePointAt(1));
        System.out.println("aceg".codePointAt(2));
        System.out.println("aceg".codePointAt(3));
        //codePointCount()
        String test1 = "ab\uD835\uDD6Bcd";
        System.out.println(test1.length());
        System.out.println(test1.codePointCount(0, test1.length()));
        System.out.println("aceg".codePointCount(0, 4));// = length
        //offsetByCodePoints()
        System.out.println("ab\uD835\uDD6Bcd".offsetByCodePoints(0, 5));

        String getCharsTest = "123";
        char[] getCharsTest1 = new char[]{'a', 'b', 'c'};
        getCharsTest.getChars(0, 2, getCharsTest1, 1);
        System.out.println(getCharsTest + ":" + getCharsTest1[0] + ":" + getCharsTest1[1] + ":"
                + getCharsTest1[2]);
        System.out.println(Math.round(-1.5));
        System.out.println((getCharsTest.equals("123")==true)+""+getCharsTest.hashCode()+"123".hashCode());
    }
}
