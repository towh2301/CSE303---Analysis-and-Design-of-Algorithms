import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIPAIR {
    static InputReader sc = new InputReader(System.in);
    static int numOfTestcases, numOfGifts, result, priceOfGift;
    static HashMap<Integer, Integer> giftMap;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        numOfTestcases = sc.nextInt();
        solve(numOfTestcases);
        System.out.println(sb);
    }

    public static void solve(int testcases) {
        while(testcases != 0) {
            result = 0;
            giftMap = new HashMap<>();
            numOfGifts = sc.nextInt();
            for (int i = 0; i < numOfGifts; i++) {
                priceOfGift = sc.nextInt();
                giftMap.put(priceOfGift, giftMap.getOrDefault(priceOfGift, 0) + 1);
            }

            for (int appearances : giftMap.values()) {
                if (appearances > 1) {
                    result += count(appearances);
                }
            }
            sb.append(result).append("\n");
            testcases--;
        }
    }

    public static int count(int appearances){
        return appearances*(appearances - 1) / 2;
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
