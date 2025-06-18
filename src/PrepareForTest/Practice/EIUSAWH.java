package PrepareForTest.Practice;

import java.io.*;
import java.util.*;

public class EIUSAWH {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        long m = reader.nextLong();
        long high = -1, low = 0, mid = 0, ans = mid;
        long[] trees = new long[n];
        for (int idx = 0; idx < n; idx++) {
            trees[idx] = reader.nextLong();
            high = trees[idx] > high ? trees[idx] : high;
        }

        while (high >= low) {
            mid = (high + low) / 2;
            long temp = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    temp += trees[i] - mid;
                }
            }

            if (temp < m) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
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
