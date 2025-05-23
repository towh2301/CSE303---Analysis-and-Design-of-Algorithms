import java.util.*;
import java.io.*;

public class EIUGIFTS {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);

        int itemCount = reader.nextInt();
        int budget = reader.nextInt();
        int[] prices = new int[itemCount];

        for (int i = 0; i < itemCount; i++) {
            prices[i] = reader.nextInt();
        }

        findBestGiftPair(prices, budget);
    }

    private static void findBestGiftPair(int[] prices, int budget) {
        Arrays.sort(prices);
        int left = 0, right = prices.length - 1;
        int maxSum = -1, minDiff = -1;

        while (left < right) {
            int sum = prices[left] + prices[right];
            int diff = Math.abs(prices[left] - prices[right]);

            if (sum <= budget) {
                if (sum > maxSum || (sum == maxSum && diff < minDiff)) {
                    maxSum = sum;
                    minDiff = diff;
                }
                left++;
            } else {
                right--;
            }
        }

        if (maxSum != -1) {
            System.out.println(maxSum + " " + minDiff);
        } else {
            System.out.println("-1 -1");
        }
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


