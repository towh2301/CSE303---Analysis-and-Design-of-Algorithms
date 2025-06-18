package PrepareForTest.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EIPAIR {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();

        while (n-- > 0) {
            int m = reader.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int num = reader.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            long result = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int val = entry.getValue();

                if (val < 2) result += 0;
                else {
                    result += (long) val * (val - 1) / 2;
                }
            }

            sb.append(result).append("\n");
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
