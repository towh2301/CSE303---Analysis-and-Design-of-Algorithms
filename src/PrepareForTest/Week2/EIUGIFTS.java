package PrepareForTest.Week2;

import java.io.*;
import java.util.*;

public class EIUGIFTS {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {

        // Initialize
        int gifts = reader.nextInt();
        int paper = reader.nextInt();
        double[] giftList = new double[gifts];
        double[] paperList = new double[paper];

        // Input
        for (int i = 0; i < gifts; i++) {
            giftList[i] = reader.nextDouble();
        }
        for (int i = 0; i < paper; i++) {
            paperList[i] = reader.nextDouble();
        }

        // Sort
        Arrays.sort(giftList);
        Arrays.sort(paperList);

        // Solve
        int i = 0, j = 0, cnt = 0;
        while (i < gifts && j < paper) {
            double size = paperList[j] / giftList[i];

            if (size > 3.0) i++;
            else if (size < 2.0) j++;
            else {
                j++;
                i++;
                cnt++;
            }
        }

        System.out.println(cnt);
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
