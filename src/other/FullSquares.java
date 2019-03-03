package other;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSquares {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1000; i < 10000; i++) {
            double temp = Math.sqrt(i);
            if(temp == Math.ceil(temp))
                list.add(i);
        }
        System.out.println(list);

        List<Integer> res = new ArrayList<>();
        for(int num : list) {
            int k = findMaxK(num);
            for(int i = 1; i <= k; i++) {
                int razn = 1000 * i + 100 * i + 10 * i + i;
                int newnum = num - razn;
                double temp = Math.sqrt(newnum);
                if(temp == Math.ceil(temp)) {
                    System.out.println(newnum);
                    res.add(num);
                }
            }
        }
        System.out.println(res);
    }


    public static int findMaxK(int num) {
        String s = String.valueOf(num);
        int k = 9;
        for(int i = 0; i < s.length(); i++) {
            int temp = Character.digit(s.charAt(i), 10);
            k = Math.min(k, temp);
        }
        return k;
    }
}


