package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EI2122Q1ADAF1 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int[] prices = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prices[i] = reader.nextInt();
        }

        long[][] dp = new long[n][2];
        dp[0][0] = 2 * prices[0];
        dp[0][1] = prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + prices[i];
            dp[i][0] = dp[i - 1][1] + prices[i] * 2;
        }

        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }

    private static final class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
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
