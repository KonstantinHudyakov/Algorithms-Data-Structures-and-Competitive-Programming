package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,1};
        int[] b = {3,4,1,2,1,3};
        int[] res = longestCommonSubsequence(a, b);
        for(int i = 0; i < res.length; i++)
            System.out.println(res[i] + " ");
    }

    static int[] longestCommonSubsequence(int[] a, int[] b) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            dp.add(new ArrayList<>());
            for(int j = 0; j < b.length; j++)
                dp.get(i).add(new ArrayList<>());
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                List<Integer> curr = dp.get(i).get(j);
                if(i == 0 || j == 0) {
                    if(a[i] == b[j])
                        curr.add(a[i]);
                }
                else if(a[i] == b[j]) {
                    curr.addAll(dp.get(i - 1).get(j - 1));
                    curr.add(a[i]);
                }
                else {
                    if (dp.get(i).get(j - 1).size() > dp.get(i - 1).get(j).size())
                        curr.addAll(dp.get(i).get(j - 1));
                    else
                        curr.addAll(dp.get(i - 1).get(j));
                }
            }
        }
        List<Integer> list = dp.get(a.length - 1).get(b.length - 1);
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}
