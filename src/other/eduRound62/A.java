package other.eduRound62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(Integer.parseInt(line[i]));

        int i = 0;
        int count = 0;
        while(i < n) {
            Set<Integer> notRead = new HashSet<>();
            notRead.add(list.get(i));
            i++;
            while(!notRead.isEmpty() && i < n) {
                notRead.remove(i);
                if(notRead.isEmpty())
                    break;
                notRead.add(list.get(i));
                i++;
            }
            count++;
        }
        System.out.println(count);
    }
}

//1 - 1
//2 - 3 3 - 3
//4 - 6 6 - 6
//5 - 7 7 - 8 8 - 8