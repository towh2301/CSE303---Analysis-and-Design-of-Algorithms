package Lab2;

import java.util.*;
import java.io.*;

public class EI2122Q1ADAM1 {
    private static final InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int size = reader.nextInt();
        long x = reader.nextInt();

        List<Long> nums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nums.add(reader.nextLong());
        }
        Collections.sort(nums);

        // nums[j] - nums[i] = x => nums[j] = nums[i] + x
        solve(nums, x);
    }

    public static void solve(List<Long> nums, long x) {
        int count = 0;
        Map<Long, Integer> appearanceMap = new HashMap<>();

        for (Long num : nums) {
            long res = num + x;
            if (appearanceMap.containsKey(num)) {
                count += appearanceMap.get(num);
                continue;
            }
            appearanceMap.put(res, appearanceMap.getOrDefault(res, 0) + 1);
        }

//        long res = num - x;
//        count += appearanceMap.getOrDefault(res, 0);
//        appearanceMap.put(num, appearanceMap.getOrDefault(num, 0) + 1);

        System.out.println(count);
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
