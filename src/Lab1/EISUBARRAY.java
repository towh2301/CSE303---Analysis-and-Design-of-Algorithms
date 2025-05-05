package Lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EISUBARRAY {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int length = sc.nextInt();
        System.out.println(solve(length));
    }

    public static long solve(int length) {
        long max = Integer.MIN_VALUE;
        long sumPos = 0, sumNeg = 0;
        long[] arr = new long[length];

        // receive input for arr
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();

            sumNeg += arr[i];
            sumPos += arr[i];
            sumNeg = sumNeg > 0 ? 0 : sumNeg;
            sumPos = sumPos < 0 ? 0 : sumPos;

            max = findMax(max, sumNeg, sumPos);
        }

        return max;
    }

    public static long findMax(long max, long sumNeg, long sumPos) {
        max = Math.max(max, sumPos);
        max = Math.max(max, Math.abs(sumNeg));
        return max;
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


