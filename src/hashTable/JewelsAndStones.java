package hashTable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for(char ch : S.toCharArray()) {
            if(J.contains(String.valueOf(ch)))
                res++;
        }
        return res;
    }
}
