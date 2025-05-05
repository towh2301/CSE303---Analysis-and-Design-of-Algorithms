package Lab2;

import java.io.*;
import java.util.*;

public class EILOVE {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        long numOfGifts = reader.nextLong();
        long money = reader.nextLong();
        System.out.println(solve(numOfGifts, money));
    }

    public static long solve(long numOfGifts, long money) {
        long res = -1;

        for (int i = 0; i < numOfGifts; i++) {
            long gift = reader.nextLong();
            if (gift <= money) {
                res = Math.max(res, gift);
            }
        }

        return res;
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
