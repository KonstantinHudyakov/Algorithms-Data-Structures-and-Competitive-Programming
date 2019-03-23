package competitiveProgramming.codeforces.round548;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        String[] line = reader.readLine().split(" ");
        for(int i = 0; i < n; i++)
            list.add(Integer.parseInt(line[i]));

        long count = list.get(n - 1);
        int cur;
        int next;
        for(int i = n - 2; i >= 0; i--) {
            cur = list.get(i);
            next = list.get(i + 1);
            if(cur == 0 || next == 0)
                break;
            if(cur < next)
                count += cur;
            else if(cur >= next) {
                count += next - 1;
                list.set(i, next - 1);
            }
        }
        System.out.println(count);
    }
}
