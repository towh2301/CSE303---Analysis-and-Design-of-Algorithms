package Labs;

import java.io.*;
import java.util.*;

public class Week_6 {

    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();
    private static final long MOD = 10000000;

    public static void main(String[] args) {
        // EIUCOL();
        System.out.println("Hello");
    }

    public static void EIUGAME2() {
        int rows = reader.nextInt();
        int cols = reader.nextInt();
        long[][] matrix = new long[rows][cols];
        long[][] dp = new long[rows][cols];
        long[][] ways = new long[rows][cols];

        // Fill the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = reader.nextLong();
            }
        }

        dp[0][0] = matrix[0][0];
        ways[0][0] = 1;

        // Fill the first row
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
            ways[0][i] = 1;
        }

        // Fill the first col
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            ways[i][0] = 1;
        }

        // Check the path (go choose left or top
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                long top = dp[i - 1][j] + matrix[i][j];
                long left = dp[i][j - 1] + matrix[i][j];

                dp[i][j] = Math.max(top, left);

                if (top < left) {
                    ways[i][j] = ways[i][j - 1];
                }
                if (top > left) {
                    ways[i][j] = ways[i - 1][j];
                }
                if (left == top) {
                    ways[i][j] = (ways[i][j - 1] + ways[i - 1][j]) % MOD;
                }
            }
        }

        // Show the result
        System.out.println(dp[rows - 1][cols - 1] + " " + ways[rows - 1][cols - 1]);
    }

    public static void EIBORE() {
        int n = reader.nextInt();
        long[] count = new long[100001];
        int x;
        int max = 0;

        // Fill the arr
        for (int i = 0; i < n; i++) {
            x = reader.nextInt();
            count[x]++; // save the appearances
            max = Math.max(x, max);
        }

        long[] dp = new long[max + 1];
        dp[0] = 0;
        dp[1] = count[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
        }

        System.out.println(dp[max]);
    }

    public static void EITHIEF2() {
        int items = reader.nextInt();
        int maxWeights = reader.nextInt();

        int[] weights = new int[items + 1];
        int[] values = new int[items + 1];

        for (int i = 1; i <= items; i++) {
            weights[i] = reader.nextInt();
            values[i] = reader.nextInt();
        }

        long[][] dp = new long[items + 1][maxWeights + 1];

        for (int i = 1; i <= items; i++) {
            for (int j = 1; j <= maxWeights; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println();
        System.out.println(dp[items][maxWeights]);
    }

    public static void EIUDP2() {

    }

    public static void EIUCOL() {
        int x = reader.nextInt();
        int[] prices = new int[3];
        for (int i = 0; i < 3; i++) {
            prices[i] = reader.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int price : prices) {
                if (i >= price && dp[i - price] != -1) {
                    dp[i] = Math.max(dp[i - price] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[x]);
    }

    public static void EISTORE() {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = reader.nextInt();
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, m + 1);
        dp[0] = 0; // Initialize the base value

        for (int i = 1; i <= m; i++) {
            for (int price : prices) {
                if (i >= price) {
                    dp[i] = Math.min(dp[i], dp[i - price] + 1);
                }
            }
        }

        System.out.println(dp[m]);

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
