
import java.util.*;
import java.io.*;

class EIULOVE {
    static InputReader reader = new InputReader(System.in);
    public static void main(String[] args) {
        int count = reader.nextInt();
        long limit = reader.nextLong();
        long maxUnderLimit = -1;

        for (int i = 0; i < count; i++) {
            long value = reader.nextLong();
            if (value <= limit && value > maxUnderLimit) {
                maxUnderLimit = value;
            }
        }

        System.out.println(maxUnderLimit);
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