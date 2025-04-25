import java.io.*;
import java.util.*;

public class EIPAGE {
    private static final InputReader reader = new InputReader(System.in);
    private static final StringBuilder sb = new StringBuilder();
    private static final List<Integer> pageNumbers = new ArrayList<>();
    private static final List<List<Integer>> pageList = new ArrayList<>();

    public static void main(String[] args) {
        int numPages = reader.nextInt();
        solve(numPages);
    }

    public static void solve(int numPages) {
        for (int i = 0; i < numPages; i++) {
            int pageNumber = reader.nextInt();
            pageNumbers.add(pageNumber);
        }
        Collections.sort(pageNumbers);

        // Find the consecutive pages
        for (int i = 0; i < pageNumbers.size(); i++) {
            List<Integer> currentPages = new ArrayList<>();
            currentPages.add(pageNumbers.get(i));

            while (i + 1 < pageNumbers.size() && pageNumbers.get(i + 1) == pageNumbers.get(i) + 1) {
                currentPages.add(pageNumbers.get(i + 1));
                i++;
            }
            pageList.add(currentPages);
        }

        // Read the pageList
        for (List<Integer> currentPages : pageList) {
            if (currentPages.size() == 1) {
                sb.append(currentPages.get(0)).append(" ");
            } else if (currentPages.size() == 2) {
                sb.append(currentPages.get(0)).append(" ").append(currentPages.get(currentPages.size() - 1)).append(" ");
            } else {
                sb.append(currentPages.get(0)).append("-").append(currentPages.get(currentPages.size() - 1)).append(" ");
            }
        }

        System.out.print(sb.toString());
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
