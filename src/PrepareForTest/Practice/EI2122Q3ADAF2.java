package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EI2122Q3ADAF2 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = reader.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        // solve(arr, n);
        solve_dp(n);
    }

    public static void solve_dp(int n) {
        int totalSum = n * (n + 1) / 2;

        // Cannot divide into half
        if (totalSum % 2 != 0) {
            System.out.println(0);
            return;
        }


        int target = totalSum / 2;
        long[] dp = new long[target + 1];
        dp[0] = 1;

        // How many ways to create sum of J if use I ?
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= i; j--) {
                dp[j] += dp[j - i] % MOD;
            }
        }

        System.out.println((dp[target] / 2) % MOD);

    }

    public static void solve(long[] arr, int n) {
        long subsets = (long) (Math.pow(2, n) - 1);
        long totalSum = (long) n * (n + 1) / 2;

        // Cannot divide
        if (totalSum % 2 != 0) {
            System.out.println(0);
            return;
        }

        long count = 0;

        for (long i = 1; i <= subsets; i++) {
            String temp = Long.toBinaryString(i);
            while (temp.length() < arr.length) {
                temp = "0" + temp;
            }

            long sum_1 = 0, sum_0 = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (String.valueOf(temp.charAt(j)).equals("1")) {
                    sum_1 += arr[j];
                }
            }
            sum_0 = totalSum - sum_1;
            count += sum_1 == sum_0 ? 1 : 0;
        }

        System.out.println((count / 2) % MOD);
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
