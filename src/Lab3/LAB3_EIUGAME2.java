package Lab3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LAB3_EIUGAME2 {
    private static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int rows = reader.nextInt();
        int cols = reader.nextInt();
        Map<Long, Long> map = new HashMap<>();

        // Init matrix
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = reader.nextLong();
            }
        }

        long[][] tempMatrix = new long[rows][cols];
        tempMatrix[0][0] = matrix[0][0]; // Base value

        // Fill the first row
        for (int i = 1; i < cols; i++) {
            // Plus the value of the previous first row column
            tempMatrix[0][i] = tempMatrix[0][i - 1] + matrix[0][i];
            map.put(tempMatrix[0][i], map.getOrDefault(tempMatrix[0][i], 0L) + 1);
        }

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            tempMatrix[i][0] = tempMatrix[i - 1][0] + matrix[i][0];
            map.put(tempMatrix[i][0], map.getOrDefault(tempMatrix[i][0], 1L) + 1);
        }

        // Find the max path
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                tempMatrix[i][j] = Math.max(tempMatrix[i][j - 1], tempMatrix[i - 1][j]) + matrix[i][j];
                map.put(tempMatrix[i][j], map.getOrDefault(tempMatrix[i][j], 1L) + 1);
            }
        }

        System.out.println(tempMatrix[rows - 1][cols - 1] + " " + map.get(tempMatrix[rows - 1][cols - 1]));
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
