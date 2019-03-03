package hashTable;

import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;

    }
}

//10:
//1 3
//3 1
//1 1 2 2
//1 2 2 1
//2 2 1 1
//1 1 1 1 1 1 2
//1 1 1 1 1 2 1
//1 1 1 1 2 1 1
//1 1 1 2 1 1 1
//1 1 2 1 1 1 1
//1 2 1 1 1 1 1
//2 1 1 1 1 1 1