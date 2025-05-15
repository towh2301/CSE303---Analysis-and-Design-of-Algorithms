package Lab3;

import java.io.*;
import java.util.*;

class LAB3_EIEQUALS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        Map<Integer, Integer> numMap = new HashMap<>();

        // Put to map the value of 2 array with the appearance of key
        // Key is represented for the different number in two arrays, if appearance = 0
        // => same
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            numMap.put(num, numMap.getOrDefault(num, 0) - 1);
        }

        solve(k, numMap);
    }

    public static void solve(int k, Map<Integer, Integer> numMap) {
        boolean isValid = true;

        for (Map.Entry<Integer, Integer> num : numMap.entrySet()) {
            // The appearance > 1 || < -1 mean value is redundant => cannot transform
            if (num.getValue() > 1) {
                System.out.println("NO");
                return;
            }

            if (Math.abs(num.getValue()) == 1) {
                isValid = Math.abs(num.getKey() - k) <= k;
                if (!isValid) {
                    break;
                }
            }
        }
        System.out.println(isValid ? "YES" : "NO");
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
                } catch (IOException ignored) {
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