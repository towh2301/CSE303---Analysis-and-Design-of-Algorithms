package Lab4;

import java.io.*;
import java.util.*;

class EIU_THIEF2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int numberOfItems = reader.nextInt();
        int maxWeight = reader.nextInt();
        int[] itemWeights = new int[numberOfItems + 1];
        int[] itemValues = new int[numberOfItems + 1];

        // Read the number of items and the maximum weight
        for (int i = 1; i <= numberOfItems; i++) {
            itemWeights[i] = reader.nextInt();
            itemValues[i] = reader.nextInt();
        }

        // Initialize the DP array
        long[][] dp = new long[numberOfItems + 1][maxWeight + 1];

        for (int i = 0; i <= numberOfItems; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= maxWeight; j++) {
            dp[0][j] = 0;
        }

        for(int i = 1; i <= numberOfItems; i++) {
            for(int j = 1; j <= maxWeight; j++) {
                if(itemWeights[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - itemWeights[i]] + itemValues[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[numberOfItems][maxWeight]);
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
