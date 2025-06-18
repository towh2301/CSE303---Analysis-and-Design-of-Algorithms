package PrepareForTest.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFTS {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int k = reader.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = reader.nextInt();
        }
        Arrays.sort(price);

        int i = 0, j = n - 1;
        int maxSum = -1;
        int minDiff = Integer.MAX_VALUE;

        while (i < j) {
            int sum = price[i] + price[j];
            int diff = price[j] - price[i];

            if (sum > k) {
                j--;
            } else {
                if (sum > maxSum || (sum == maxSum && diff < minDiff)) {
                    maxSum = sum;
                    minDiff = diff;
                }
                i++;
            }
        }

        if (maxSum == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(maxSum + " " + minDiff);
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
