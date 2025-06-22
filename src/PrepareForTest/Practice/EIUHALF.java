package PrepareForTest.Practice;

import java.io.*;
import java.util.StringTokenizer;

public class EIUHALF {

    private static final InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        int end = n - 1, start = 0, mid = n / 2, first = 0, second = 0, min = Integer.MAX_VALUE;

        while (end > start) {
            mid = (end + start) / 2;

            first = calHalf(0, mid, arr);
            second = calHalf(mid, n, arr);

            if (first == second) break;

            if (first > second) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(Math.abs(first - second));

    }

    public static int calHalf(int start, int end, int[] arr) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
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
