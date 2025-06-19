package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EIUPHISTONE2 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int T = reader.nextInt();

        while (T-- > 0) {
            int h = reader.nextInt();
            int w = reader.nextInt();
            int max = 0;

            int[][] val = new int[h + 1][w + 1];
            int[][] dp = new int[h + 1][w + 1];

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    val[i][j] = reader.nextInt();
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    int n0, n1, n2, nMax;
                    if (j != w) {
                        n0 = dp[i - 1][j - 1] + val[i][j];
                        n1 = dp[i - 1][j] + val[i][j];
                        n2 = dp[i - 1][j + 1] + val[i][j];
                        nMax = Math.max(n0, n1);
                        nMax = Math.max(nMax, n2);
                    } else {
                        n0 = dp[i - 1][j - 1] + val[i][j];
                        n1 = dp[i - 1][j] + val[i][j];
                        nMax = Math.max(n0, n1);
                    }

                    dp[i][j] = nMax;
                    max = Math.max(max, dp[i][j]);
                }
            }
            sb.append(max).append("\n");
        }

        System.out.println(sb.toString());
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
