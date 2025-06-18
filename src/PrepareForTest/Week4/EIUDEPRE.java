package PrepareForTest.Week4;

import java.io.*;
import java.util.StringTokenizer;

public class EIUDEPRE {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        double c = reader.nextDouble();
        double r = reader.nextDouble();

        double high = 1.0, low = 0, mid = .5;
        while (high - low > 0.00000001) {
            mid = (high + low) / 2;
            double temp = c;

            for (int i = 0; i < n; i++) {
                temp -= temp * (mid - mid * i / n);
            }

            if (temp < r) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.printf("%.7f", mid);
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
