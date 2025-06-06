package Labs;

import java.io.*;
import java.util.*;

public class Week_5 {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        EIULOGGING3();
    }

    public static void LOGGING() {
        int n = reader.nextInt();
        int[] trees = new int[n];
        long[] dp = new long[n + 2];

        for (int i = 0; i < n; i++) {
            trees[i] = reader.nextInt();
        }

        for (int i = 2; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + trees[i - 2]);
        }

        System.out.println(dp[dp.length - 1]);
    }

    public static void EIULOGGING2() {
        int n = reader.nextInt();
        long[] values = new long[n];
        long[] dp = new long[n + 3];
        for (int i = 0; i < n; i++) {
            values[i] = reader.nextInt();
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 3] + values[i - 3]);
        }

        System.out.println(dp[dp.length - 1]);
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

    public static void EIJUMP() {
        int n = reader.nextInt();
        int[] jump = new int[n];
        int[] dp = new int[n];

        Map<Integer, Integer> jumpMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            jump[i] = reader.nextInt();
        }

        // Stand still
        dp[0] = 0;
        jumpMap.put(jump[0], 0);

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, jumpMap.getOrDefault(jump[i], 1000000000) + 1);
            jumpMap.put(jump[i], dp[i]);
        }

        System.out.println(dp[n - 1]);
    }

    public static void EIUGAME() {
        // Todo implement this
    }

    private static final class OptimizedReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public OptimizedReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public OptimizedReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
