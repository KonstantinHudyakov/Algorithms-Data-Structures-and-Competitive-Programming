package competitiveProgramming.codeforces.round548;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(Character.digit(s.charAt(i), 10));
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(list.get(i - 1) % 2 == 0)
                count += i;
        }
        System.out.println(count);
    }
}
