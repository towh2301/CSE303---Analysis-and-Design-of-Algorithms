import java.io.*;
import java.util.*;

public class EI2122Q1ADAM1 {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int numberOfElements = reader.nextInt();
        int subtraction = reader.nextInt();
        solve(numberOfElements, subtraction);
    }

    public static void solve(int numberOfElements, int subtraction) {
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < numberOfElements; i++) {
            arr.add(reader.nextInt());
        }

        for (int i = numberOfElements - 1; i >= 0; i--) {
            int target = arr.get(i) + subtraction;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        System.out.println(res);
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
