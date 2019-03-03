package arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        if(n <= 2)
            return 0;
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < n; i++) {
            int num = (int)Math.sqrt(i);
            boolean flag = false;
            for(int j = 0; !flag && j < primes.size() && primes.get(j) <= num; j++) {
                if(i % primes.get(j) == 0)
                    flag = true;
            }
            if(!flag)
                primes.add(i);
        }
        return primes.size();
    }
}
