package PrepareForTest.Week2;

import java.io.*;
import java.util.*;

public class EIQUEEN {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static String solve() {
        // Set<Integer> horizontal = new HashSet<>(); don't need
        Set<Integer> vertical = new HashSet<>();
        Set<Integer> diagonal_1 = new HashSet<>(); //  '/'
        Set<Integer> diagonal_2 = new HashSet<>(); //  '\'
        String[] puzzle = new String[8];

        for (int i = 0; i < 8; i++) {
            puzzle[i] = reader.next();
        }

        for (int i = 0; i < 8; i++) {
            int idx = puzzle[i].indexOf("*");
            int dia_1 = i - idx;
            int dia_2 = i + idx;

            if (vertical.contains(idx) || diagonal_1.contains(dia_1) || diagonal_2.contains(dia_2)) return "invalid";

            vertical.add(idx);
            diagonal_1.add(dia_1);
            diagonal_2.add(dia_2);
        }

        return "valid";
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
