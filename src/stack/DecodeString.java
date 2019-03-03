package stack;

import java.util.Scanner;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString obj = new DecodeString();
        String s = "3[a]2[bc]";
        String res = obj.decodeString(s);
        System.out.println(res);
    }

    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i < s.length() && !Character.isDigit(s.charAt(i))) {
            str.append(s.charAt(i));
            i++;
        }
        String numOfIterations = "";
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            numOfIterations += s.charAt(i);
            i++;
        }
        if(i >= s.length())
            return str.toString();
        int num = Integer.parseInt(numOfIterations);
        String iteration = getIterationPart(s.substring(i));
        i += iteration.length() + 2;
        for(int j = 0; j < num; j++)
            str.append(decodeString(iteration));
        if(i >= s.length())
            return str.toString();
        else
            str.append(decodeString(s.substring(i)));
        return str.toString();
    }

    public String getIterationPart(String s) {
        int brackets = 1;
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < s.length() && brackets > 0; i++) {
            char ch = s.charAt(i);
            if(ch != ']' || brackets > 1)
                str.append(s.charAt(i));
            if(ch == '[')
                brackets++;
            if(ch == ']')
                brackets--;
        }
        return str.toString();
    }
}
