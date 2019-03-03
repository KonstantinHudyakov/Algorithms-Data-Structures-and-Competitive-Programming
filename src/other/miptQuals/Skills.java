package other.miptQuals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Skills {
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int max = 0;
        int maxTeams = 0;
        for(int i = 0; i < topic.length; i++) {
            for(int j = i + 1; j < topic.length; j++) {
                String mem1 = topic[i];
                String mem2 = topic[j];
                int cur = 0;
                for(int k = 0; k < mem1.length(); k++) {
                    if(mem1.charAt(k) == '1' || mem2.charAt(k) == '1')
                        cur++;
                }
                maxTeams += (cur == max) ? 1 : 0;
                if(cur > max) {
                    maxTeams = 1;
                    max = cur;
                }
            }
        }
        return new int[] {max, maxTeams};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
