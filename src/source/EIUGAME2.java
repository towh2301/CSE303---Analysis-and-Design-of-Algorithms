
import java.util.*;
import java.io.*;

class EIUGAME2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String args[]) {
        int n = reader.nextInt();
        int m = reader.nextInt();

        long[][] matrix = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }

        long[][] dp = new long[n][m];
        long[][] count = new long[n][m];

        dp[0][0] = matrix[0][0];
        count[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
            count[i][0] = 1;
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
            count[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long top = dp[i - 1][j];
                long left = dp[i][j - 1];

                dp[i][j] = Math.max(top, left) + matrix[i][j];

                count[i][j] = 0;

                if (dp[i][j] == top + matrix[i][j]) {
                    count[i][j] = (count[i][j] + count[i - 1][j]) % (int) 1e7;
                }
                if (dp[i][j] == left + matrix[i][j]) {
                    count[i][j] = (count[i][j] + count[i][j - 1]) % (int) 1e7;
                }
            }
        }

        System.out.println(dp[n - 1][m - 1] + " " + count[n - 1][m - 1]);

    }

    static class InputReader {

        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
