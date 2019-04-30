package competitiveProgramming.yandexInternshipContest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<String> numbers = new ArrayList<>();
        List<String> templates = new ArrayList<>();
        for(int i = 0; i < n; i++)
            numbers.add(reader.readLine());

        int m = Integer.parseInt(reader.readLine());
        for(int i = 0; i < m; i++)
            templates.add(reader.readLine());

        List<String> templStart = new ArrayList<>();
        List<Integer> various = new ArrayList<>();
        List<String> formats = new ArrayList<>();

        for(String s : templates) {
            String[] temp = s.split(" - ");
            String left = temp[0];
            various.add(left.lastIndexOf('X') - left.indexOf('X') + 1);

            String[] nums = left.split("\\D+");
            StringBuilder builder = new StringBuilder();
            for(String str : nums)
                builder.append(str);
            templStart.add(builder.toString());

            formats.add(left.replaceAll("X", "%c") + " - " + temp[1]);
        }

        List<String> parsedNumbers = new ArrayList<>();
        for(String s : numbers) {
            String[] temp = s.split("\\D+");
            StringBuilder builder = new StringBuilder();
            for(String str : temp)
                builder.append(str);
            parsedNumbers.add(builder.toString());
        }

        for(String s : parsedNumbers) {
            for(int i = 0; i < formats.size(); i++) {
                String start = templStart.get(i);
                if(s.startsWith(start) && start.length() + various.get(i) == s.length()) {
                    String format = formats.get(i);

                    Character[] arr = new Character[s.length() - start.length()];
                    for(int j = start.length(); j < s.length(); j++)
                        arr[j - start.length()] = s.charAt(j);
                    System.out.println(String.format(format, arr));
                    break;
                }
            }
        }




    }
}
