package PrepareForTest.Week2;

import java.io.*;
import java.util.*;

public class EIPAGES {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        List<Integer> list = new ArrayList<>();
        int n = reader.nextInt();

        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            list.add(num);
        }
        Collections.sort(list);

        int first = list.get(0), continuous = 0, previous = first, num = first;
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                num = list.get(i);
            }

            if (num - 1 == previous) {
                continuous += 1;
                previous = num;
                continue;
            }

            // Check if continuous > 1
            if (continuous == 1) {
                sb.append(first).append(" ").append(previous).append(" ");
            } else if (continuous > 1) {
                sb.append(first).append("-").append(previous).append(" ");
            } else {
                sb.append(previous).append(" ");
            }

            first = num;
            previous = num;
            continuous = 0;
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
