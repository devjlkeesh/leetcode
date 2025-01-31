package leetcode;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;

public class Easy1175 {

    public int numPrimeArrangements(int n) {
        long mod = 1000000007;
        IntSupplier countPrimes = () -> {
            boolean[] primes = new boolean[n + 1];
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;

            for (int i = 2; i * i <= n; i++) {
                if (primes[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        primes[j] = false;
                    }
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (primes[i]) {
                    count++;
                }
            }
            return count;
        };

        IntFunction<Long> factorial = (num) -> {
            long result = 1;
            for (int i = 2; i <= num; i++) {
                result = (result * i) % mod;
            }
            return result;
        };

        int pc = countPrimes.getAsInt();
        int cc = n - pc;
        return (int) (factorial.apply(pc) * factorial.apply(cc) % mod);
    }


}
