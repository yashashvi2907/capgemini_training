package Strings;

import java.util.Scanner;

public class StringConcepts {

    public static void main(String[] args)
    {
        // string creation method --
        // method1
        String name = "khusj";
        //method2
        String namee = new String("khushi");

        // immutable - only we can do our selve
        // comparision between string -- returns diff between first differ char
        System.out.println(name.compareTo(namee));
        // checks is equal or not
        System.out.println(name.equalsIgnoreCase(namee));

        // == checks refrence

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String l = sc.nextLine();
        System.out.println(s + l);
        String f = s+l;
        char[] arr = f.toCharArray();
        for( char it : arr)
        {
            System.out.println(it);
        }
        name.toUpperCase();
        name.toLowerCase();
        String demo = "yasahahsvi singh";
        name.trim(); // removes space
        name.startsWith("bike"); // -- returns true/false
        name.endsWith("hdg"); // same returns true/false
        name.equals("khushi"); // checks equality
        // charAt() -- returns at index  waht character is present,
        // it returns charater at that index
        // most used, to access char at particular index

        // typecast --
        int age = 123;
        String as = String.valueOf(age);
        System.out.println(age+2); // 125
        System.out.println(as + 2); // 1232

        // replace -- >
        name.replace("java", "hdfr");
        System.out.println(name.contains("good"));

        // contains -- >
        System.out.println();

        // split string --

        String[] words = name.split(",");

        for(String word : words) {
            System.out.println(word);
        }


        // stringbuilder - immutable type

        StringBuilder sb = new StringBuilder("hello");
        // method chaining as well immutable
        sb.append("world").reverse();

        // stringbuffer -- provide thread safety
        // provide thread methods



    }

}
