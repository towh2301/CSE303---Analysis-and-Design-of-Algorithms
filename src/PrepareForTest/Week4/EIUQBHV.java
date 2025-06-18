package PrepareForTest.Week4;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class EIUQBHV {

    private static InputReader reader = new InputReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        String pass = reader.next();
        TreeSet<String> generatedPasses = new TreeSet<>();

        generatedPasses.add(String.valueOf(pass.charAt(0)));

        // Generate pass
        for (int i = 1; i < pass.length(); i++) {
            TreeSet<String> temp = new TreeSet<>();

            for (String p : generatedPasses) {
                for (int j = 0; j <= p.length(); j++) {
                    String tempPass = p.substring(0, j) + pass.charAt(i) + p.substring(j);
                    temp.add(tempPass);
                }
            }
            generatedPasses = temp;
        }

        sb.append(generatedPasses.size()).append("\n");
        for (String p : generatedPasses) {
            sb.append(p).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static long countSimpleFactorial(int n) {
        if (n == 0) return 1;

        long num = 1;

        for (int i = 1; i <= n; i++) {
            num *= i;
        }

        return num;
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
