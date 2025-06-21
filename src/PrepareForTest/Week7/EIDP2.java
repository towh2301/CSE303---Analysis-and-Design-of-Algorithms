package PrepareForTest.Week7;

import java.io.*;
import java.util.StringTokenizer;

public class EIDP2 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int T = reader.nextInt();

        while (T-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = reader.nextInt();
            }

            int[] prefix = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] + a[i - 1];
            }

            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1]; // không chọn giờ i

                for (int len = 1; len <= k && i - len >= 0; len++) {
                    int sum = prefix[i] - prefix[i - len];
                    int prev = (i - len - 1 >= 0) ? dp[i - len - 1] : 0;
                    dp[i] = Math.max(dp[i], sum + prev);
                }
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
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
