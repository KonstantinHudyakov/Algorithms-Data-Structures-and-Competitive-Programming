package other.miptQuals;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {


    static void timeInWords(int h, int m) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "quarter");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(21, "twenty one");
        map.put(22, "twenty two");
        map.put(23, "twenty three");
        map.put(24, "twenty four");
        map.put(25, "twenty five");
        map.put(26, "twenty six");
        map.put(27, "twenty seven");
        map.put(28, "twenty eight");
        map.put(29, "twenty nine");
        map.put(30, "half");

        if(m == 0)
            System.out.println(map.get(h) + " o' clock");
        else if(m == 1)
            System.out.println("one minute past " + map.get(h));
        else if(m == 15)
            System.out.println("quarter past " + map.get(h));
        else if(m < 30)
            System.out.println(map.get(m) + " minutes past " + map.get(h));
        else if(m == 30)
            System.out.println("half past " + map.get(h));
        else if(m == 45)
            System.out.println("quarter to " + map.get((h + 1) % 12));
        else if(m == 59)
            System.out.println("one minute to " + map.get((h + 1) % 12));
        else
            System.out.println(map.get(60 - m) + " minutes to " + map.get((h + 1) %12));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        timeInWords(h, m);
    }
}
