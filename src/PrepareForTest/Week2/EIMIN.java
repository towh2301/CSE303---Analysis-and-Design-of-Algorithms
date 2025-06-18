package PrepareForTest.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EIMIN {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt();
        int k = reader.nextInt();
        int min = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            treeSet.add(reader.nextInt());
        }

        treeSet.remove(0);
        int[] arr = treeSet.stream().mapToInt(x -> x).toArray();
        for (int i = 0; i < k; i++) {
            if (arr.length > i) {
                int num = arr[i] - min;
                sb.append(num).append("\n");
                min += num;
            } else {
                sb.append(0).append("\n");
            }
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
