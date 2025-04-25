import java.io.*;
import java.util.*;

public class EIQUEENS {
    static InputReader reader = new InputReader(System.in);
    static int numOfQueens = 8;

    // Define the sets to track the positions of queens
    static Set<Integer> rows = new HashSet<>();
    static Set<Integer> cols = new HashSet<>();
    static Set<Integer> diag1 = new HashSet<>();
    static Set<Integer> diag2 = new HashSet<>();

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        System.out.println(solve());
    }

    public static String solve() throws IOException {
        // Diagonal 1: row - col (\)
        // Diagonal 2: row + col (/
        String[] board = new String[numOfQueens];
        for (int i = 0; i < numOfQueens; i++) {
            board[i] = reader.nextLine();
            if (!checkQueen(i, board[i].indexOf("*"))) return "invalid";
        }

        return "valid";
    }

    public static boolean checkQueen(int row, int col) {
        if (rows.contains(row) || cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
            return false;
        }
        rows.add(row);
        cols.add(col);
        diag1.add(row - col);
        diag2.add(row + col);
        return true;
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
