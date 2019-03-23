package competitiveProgramming.codeforces.eduRound62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            if(n == 1)
                System.out.println(0);
            else {
                int res = check(line);
                System.out.println(res);
            }
        }
    }
    public static int check(String s) {
        int start = checkStart(s);
        if(start == s.length())
            return 0;
        int end = checkEnd(s);
        if(end == s.length())
            return 0;
        return Math.min(start, end);
    }

    public static int checkStart(String line) {
        int count = 0;
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '<')
                count++;
            else
                return count;
        }
        return count;
    }

    public static int checkEnd(String line) {
        int count = 0;
        for(int i = line.length() - 1; i >= 0; i--) {
            if(line.charAt(i) == '>')
                count++;
            else
                return count;
        }
        return count;
    }
}