package Labs;

import java.util.*;
import java.io.*;

class test {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws java.lang.Exception {
        EIULOGGING3();
    }

    public static void EIULOGGING3() {
        int n = reader.nextInt();
        long[] values = new long[n];
        long[] dp = new long[n + 2];

        for (int i = 0; i < n; i++) {
            values[i] = reader.nextInt();
        }

        long[] countWays = new long[n + 2];
        Arrays.fill(countWays, 1);
        for (int i = 2; i < dp.length; i++) {
            long tempNewValue = dp[i - 2] + values[i - 2];

            // Choose cut or not
            dp[i] = Math.max(dp[i - 1], tempNewValue);

            if (dp[i - 1] == tempNewValue) {
                countWays[i] = (countWays[i - 1] + countWays[i - 2] % MOD);
            } else if (dp[i] == dp[i - 1]) {
                countWays[i] = countWays[i - 1] % MOD;
            } else {
                countWays[i] = countWays[i - 2] % MOD;
            }

        }

        System.out.println(dp[dp.length - 1] + " " + countWays[countWays.length - 1]);
    }


}

