package Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LAB3_EIUSUBSET {
    private static final InputReader reader = new InputReader(System.in);
    private static final StringBuilder sb = new StringBuilder();
    private static final List<List<Double>> subsets = new ArrayList<>();

    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(reader.nextDouble());
        }
        int numOfSetsNumbers = (int) Math.pow(2, n) - 1; // The empty set has to be removed
        //numbers.sort(Collections.reverseOrder());

        /* This is for the BITMASK method */
        bitmask(numbers, numOfSetsNumbers);


        /* This is for the BACKTRACK method (time limit exceeded)

            backtrack(numbers, new ArrayList<>(), 0);

        */

        // Print the results
        //sb.append(numOfSetsNumbers).append("\n");
//        for (List<Double> subset : subsets) {
//            Collections.sort(subset);
//            for (Double d : subset) {
//                sb.append(Math.round(d)).append(" ");
//            }
//            sb.append("\n");
//        }
        System.out.println(numOfSetsNumbers);
        System.out.println(sb);
    }

    public static void backtrack(List<Double> numbers, List<Double> tempList, int start) {
        // Add to subset if there is a valid tempList (prevent empty list)
        if (!tempList.isEmpty()) {
            subsets.add(new ArrayList<>(tempList)); // Init and Add valid tempList for each round.
        }

        // Choose each value in list to create the subset(initial start = 0)
        for (int i = start; i < numbers.size(); i++) {
            // Add the value to the tempList to track in the backTracking recursion method.
            // Each value will be added to tempList each recursion round.
            tempList.add(numbers.get(i));
            backtrack(numbers, tempList, i + 1); // Callback the method to do the recursion with the i + 1 (for start from next value).
            tempList.remove(tempList.size() - 1); // Remove the last value when get out of the recursion to return to the before value list.

            /*
             * 1
             * 1 2
             * 1 2 3
             * ********
             * 1 2 3
             * 1 2
             * 1
             * */
        }
    }

    public static void bitmask(List<Double> numbers, int numOfSetsNumbers) {
        for (int i = 1; i < numOfSetsNumbers + 1; i++) { // Start from 1 so that we don't have the zero value
            String temp = Integer.toBinaryString(i); // The value is the bit result
            System.out.println(temp);

            // Fill the zero value
            while (temp.length() != numbers.size()) {
                temp = "0" + temp;
            }

            // Add to subset that the value is equal 1
            // List<Double> subset = new ArrayList<>();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    //subset.add(numbers.get(j));
                    sb.append(Math.round(numbers.get(j))).append(" ");
                }
            }
//            subsets.add(new ArrayList<>(subset));
            sb.append("\n");
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
