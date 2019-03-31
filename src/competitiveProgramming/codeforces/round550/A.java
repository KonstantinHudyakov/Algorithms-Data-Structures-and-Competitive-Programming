package competitiveProgramming.codeforces.round550;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
        }


        for (int i = 0; i < n; i++) {
            boolean flag = false;
            String s = list.get(i);
            Set<Character> set = new TreeSet<>();
            for (int j = 0; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            int count = 0;
            for (int x : set) {
                if (!set.contains((char) (x + 1)) && count != s.length() - 1) {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
                count++;
            }
            if (!flag)
                System.out.println("YES");
        }
    }
}












