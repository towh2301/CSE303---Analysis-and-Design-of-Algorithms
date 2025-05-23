import java.io.*;
import java.util.*;

public class LAB3_EIEQUALS {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();

        int[] arr_a = new int[n];
        for (int i = 0; i < n; i++) {
            arr_a[i] = reader.nextInt();
        }
        Arrays.sort(arr_a);

        int[] arr_b = new int[n];
        for (int i = 0; i < n; i++) {
            arr_b[i] = reader.nextInt();
        }
        Arrays.sort(arr_b);

        // Boolean array to track used elements
        boolean[] used = new boolean[n];
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            boolean match = false;
            for (int j = 0; j < n; j++) {
                // Check if the element at used[j] is used or not and is this satisfied the condition <= k
                if(!used[j] && Math.abs(arr_a[j] - arr_b[i]) <= k) {
                    used[j] = true;
                    match = true;
                    break;
                }
            }
            if(!match) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
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
