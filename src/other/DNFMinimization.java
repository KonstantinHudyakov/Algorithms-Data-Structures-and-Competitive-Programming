package other;

import java.util.*;

public class DNFMinimization {
    public static void main(String[] args) {
        List<String> allPermutations = new ArrayList<>();
        createPermutations(allPermutations, "", 5);

        String function = "01010101 01101101 10101111 00101111";
        List<String> fullDNF = new ArrayList<>();
        for(int i = 0; i < function.length(); i++) {
            int num = Character.digit(function.charAt(i), 10);
            if(num == 1)
                fullDNF.add(allPermutations.get(i));
        }


        List<String> firstAbbreviation = mergePermutations(fullDNF);
        List<String> secondAbbreviation = mergePermutations(firstAbbreviation);
        List<String> thirdAbbreviation = mergePermutations(secondAbbreviation);
        List<String> fourthAbbreviation = mergePermutations(thirdAbbreviation);

//        for(String s : fullDNF)
//            System.out.println(s);
//        for(String s : firstAbbreviation)
//            System.out.println(s);
//        System.out.println(firstAbbreviation.size());
//        for(String s : secondAbbreviation)
//            System.out.println(s);
//        System.out.println(secondAbbreviation.size());
//        for(String s : thirdAbbreviation)
//            System.out.println(s);
//        for(String s : fourthAbbreviation)
//            System.out.println(s);

        Set<String> result = new HashSet<>();
        result.addAll(fullDNF);
        result.addAll(firstAbbreviation);
        result.addAll(secondAbbreviation);
        result.addAll(thirdAbbreviation);
        result.addAll(fourthAbbreviation);

        for(String s : result)
            System.out.println(s);
    }

    public static void createPermutations(List<String> perm, String cur, int n) {
        if(n == 0) {
            perm.add(cur);
            return;
        }
        createPermutations(perm, cur + "0", n - 1);
        createPermutations(perm, cur + "1", n - 1);
    }

    public static List<String> mergePermutations(List<String> perm) {
        List<String> abbreviatedDNF = new ArrayList<>();
        boolean[] used = new boolean[perm.size()];
        String s1, s2;
        int diffIndex;
        for(int i = 0; i < perm.size(); i++) {
            s1 = perm.get(i);
            for(int j = i + 1; j < perm.size(); j++) {
                s2 = perm.get(j);
                diffIndex = findDifferentIndex(s1, s2);
                if(diffIndex != -1) {
                    used[i] = true;
                    used[j] = true;
                    StringBuilder mergedItem = new StringBuilder(s1);
                    mergedItem.setCharAt(diffIndex, '-');
                    abbreviatedDNF.add(mergedItem.toString());
                }
            }
        }

        List<String> temp = new ArrayList<>();
        for(int i = 0; i < perm.size(); i++) {
            if(!used[i])
                temp.add(perm.get(i));
        }
        perm.clear();
        perm.addAll(temp);
        return abbreviatedDNF;
    }

    private static int findDifferentIndex(String s1, String s2) {
        boolean found = false;
        int res = -1;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(found)
                    return -1;
                found = true;
                res = i;
            }
        }
        return res;
    }
}
