package Labs;

import java.io.*;
import java.util.*;

public class Week_7 {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        EIUGAME2();
    }

    public static void EIUGAME2() {

    }

    public static void EIBORE() {
    }

    public static void EITHIEF2() {
    }

    public static void EIUDP2() {
    }

    public static void EIUCOL() {
    }

    public static void EISTORE() {
    }

    private static final class OptimizedReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public OptimizedReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public OptimizedReader(FileInputStream stream) {
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
