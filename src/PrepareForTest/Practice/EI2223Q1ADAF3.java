package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EI2223Q1ADAF3 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) val[i] = reader.nextInt();

        long[] dp = new long[n + 1];  // dp[i] = max value up to tree i-1
        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            long maxSegment = val[i - 2] + val[i - 1];
            long sum = maxSegment;

            for (int j = i - 3; j >= 0; j--) {
                sum += val[j];
                maxSegment = Math.max(maxSegment, sum);
            }

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + maxSegment);
        }

        System.out.println(dp[n]);
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
