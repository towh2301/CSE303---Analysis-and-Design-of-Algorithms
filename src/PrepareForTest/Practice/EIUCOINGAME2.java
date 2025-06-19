package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EIUCOINGAME2 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        List<Integer> val = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            val.add(reader.nextInt());
        }

        int[][] dp = new int[n + 1][2];

        // 0: me
        // 1: opponent
        for (int i = 1; i <= n; i++) {
            if (val.isEmpty()) {
                break;
            }
            dp[i][0] = Math.max(val.get(0), val.get(val.size() - 1)) + dp[i - 1][0];
            val.remove(val.get(0) > val.get(val.size() - 1) ? 0 : val.size() - 1);

            if (val.isEmpty()) {
                break;
            }
            dp[i][1] = Math.max(val.get(0), val.get(val.size() - 1)) + dp[i - 1][1];
            val.remove(val.get(0) > val.get(val.size() - 1) ? 0 : val.size() - 1);
        }

        if (n % 2 == 0) {
            System.out.println(Math.max(dp[n / 2][0], dp[n / 2][1]));
        } else {
            System.out.println(Math.max(dp[n / 2 + 1][0], dp[n / 2 + 1][1]));
        }

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
