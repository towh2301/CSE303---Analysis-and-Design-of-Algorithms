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

            int maxEarnings = maxEarningsCarota(n, k, a);
            sb.append(maxEarnings).append("\n");
        }

        System.out.println(sb);
    }

    public static int maxEarningsCarota(int n, int k, int[] a) {
        int[] dp = new int[n + 1]; // dp[i] là số tiền lớn nhất đến giờ i

        for (int i = 0; i < n; i++) {
            // Không làm ở giờ i
            if (i > 0) {
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = 0;
            }

            // Làm ở giờ i, xem xét các đoạn làm kết thúc tại i
            for (int len = 1; len <= k && i - len + 1 >= 0; len++) {
                int start = i - len + 1; // Giờ bắt đầu của đoạn làm
                int segmentSum = 0;

                // Tính tổng tiền của đoạn làm từ start đến i
                for (int j = start; j <= i; j++) {
                    segmentSum += a[j];
                }

                // Cộng với số tiền lớn nhất trước đoạn nghỉ (nếu có)
                if (start >= k) {
                    segmentSum += dp[start - k];
                } // Nếu start < k, không có đoạn làm trước, dp[0] = 0 nên không cần cộng

                // Cập nhật dp[i+1]
                dp[i + 1] = Math.max(dp[i + 1], segmentSum);
            }
        }

        return dp[n];
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