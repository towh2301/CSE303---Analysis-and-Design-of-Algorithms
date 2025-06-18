package PrepareForTest.Week3;

import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int n = reader.nextInt(), m = reader.nextInt(), x = reader.nextInt();
        int[] men = new int[n];
        int[] women = new int[m];

        for (int i = 0; i < n; i++) men[i] = reader.nextInt();
        for (int i = 0; i < m; i++) women[i] = reader.nextInt();

        Arrays.sort(men);
        Arrays.sort(women);

        int low = 0, high = Integer.MAX_VALUE, answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFormPairs(men, women, x, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canFormPairs(int[] men, int[] women, int x, int maxDiff) {
        int i = 0, j = 0, pairs = 0;

        while (i < men.length && j < women.length) {
            if (Math.abs(men[i] - women[j]) <= maxDiff) {
                pairs++;
                i++;
                j++;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }
        }

        return pairs >= x;
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
