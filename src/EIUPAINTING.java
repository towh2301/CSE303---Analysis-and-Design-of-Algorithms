import java.io.*;
import java.util.*;

class EIUPAINTING {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        int numOfElements = reader.nextInt();
        solve(numOfElements);
    }

    public static void solve(int numOfElements) throws IOException {
        int result = 0, num = 0;
        HashMap<Integer, Integer> frequencyNumber = new HashMap<>();

        for(int i = 0; i < numOfElements; i++){
            num = reader.nextInt();
            if(frequencyNumber.containsKey(num))
                frequencyNumber.put(num, frequencyNumber.get(num) + 1);
            else
                frequencyNumber.put(num, 1);
        }

        result = numOfElements - findMaxInMap(frequencyNumber);
        System.out.println(result);
    }

    public static int findMaxInMap(HashMap<Integer, Integer> map) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            max = e.getValue() > max ? e.getValue() : max;
        }
        return max;
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
