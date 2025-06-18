package PrepareForTest.Week4;

import java.io.*;
import java.util.*;

public class EIEQUALS {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int k = reader.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            int num = reader.nextInt();
            map.put(num, map.getOrDefault(num, 0) - 1);
        }

        boolean flag = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Math.abs(entry.getValue()) > 1) {
                flag = false;
                break;
            }
            if (Math.abs(entry.getValue()) == 1) {
                flag = Math.abs(entry.getKey() - k) <= k;
                if (!flag) break;
            }
        }

        System.out.println(flag ? "YES" : "NO");

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
