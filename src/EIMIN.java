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
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            if (num != 0) {
                min = Math.min(num, min);
                set.add(num);
            }
        }


        if (min == Integer.MAX_VALUE) {
            sb.append(min);
        } else {
            set.remove(min);
            List<Integer> list = new ArrayList<>(set.stream().toList());
            Collections.sort(list);

            while (k != 0 && !list.isEmpty()) {
                k--;
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) - min);
                    if (!(list.size() == 1)) {
                        if (list.get(i) == 0 || list.get(i) < 0) {
                            list.remove(i);
                            i--;
                        }
                    }
                }
                sb.append(min).append("\n");
                min = list.get(0);
            }
        }
        System.out.println(sb);
    }

    public static int findBeforeMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int beforeMin = Integer.MAX_VALUE;
        for (Integer integer : list) {
            beforeMin = min;
            min = Math.min(integer, min);
        }
        return (min == 0) ? beforeMin : min;
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
