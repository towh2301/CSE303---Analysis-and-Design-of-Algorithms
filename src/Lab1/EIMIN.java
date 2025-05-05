package Lab1;

import java.util.*;
import java.io.*;

public class EIMIN {
    private static final InputReader reader = new InputReader(System.in);
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        solve(n, k);
    }

    public static void solve(int n, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int min = 0;
        int totalMin = 0, res = -1;
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            treeSet.add(num);
        }

        if (treeSet.first() == 0) treeSet.remove(0);
        List<Integer> sortedList = new ArrayList<>(treeSet);

        for (int i = 0; i < k; i++) {
            if (i > sortedList.size() - 1) {
                sb.append("0\n");
                continue;
            }
            min = sortedList.get(i) - totalMin;
            sb.append(min).append("\n");
            totalMin += min;
        }

        System.out.println(sb);
    }

    static class InputReader {
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
