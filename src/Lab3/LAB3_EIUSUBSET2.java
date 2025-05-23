package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LAB3_EIUSUBSET2 {
    private static final InputReader reader = new InputReader(System.in);
    private static final List<List<Long>> subsets = new ArrayList<>();

    public static void main(String[] args) {
        List<Long> numbers = new ArrayList<>();
        long n = reader.nextLong();
        long sum = reader.nextLong();

        for (int i = 0; i < n; i++) {
            numbers.add(reader.nextLong());
        }
        int numOfSetsNumbers = (int) Math.pow(2, n) - 1; // The empty set has to be removed

        System.out.println(bitmask(numbers, numOfSetsNumbers, sum));
    }

    public static int bitmask(List<Long> numbers, int numOfSetsNumbers, long sum) {
        int count = 0;
        for (int i = 1; i <= numOfSetsNumbers; i++) {
            String temp = Long.toBinaryString(i);
            while (temp.length() < numbers.size()) {
                temp = "0" + temp;
            }

            int subsetSum = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    subsetSum += numbers.get(j);
                }
            }
            count = subsetSum == sum ? count + 1 : count;
        }
        return count;
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
