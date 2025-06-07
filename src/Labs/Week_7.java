package Labs;

import java.io.*;
import java.util.*;

public class Week_7 {

    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        EIUQUISORT();
    }

    public static void EIUBISEA() {
        sb = new StringBuilder();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] arr = new int[n];
        int[] targets = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        for (int i = 0; i < m; i++) {
            targets[i] = reader.nextInt();
        }

        Arrays.sort(arr);
        for (int target : targets) {
            int high = n - 1, low = 0, mid, result = -1;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (arr[mid] == target) {
                    result = mid;
                    high = mid - 1;
                } else if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    public static void EIUMERSORT() {

    }

    public static void EIUQUISORT() {
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        sort(arr, 0, n - 1);

        sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);

            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, r);
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];

        int idx = l - 1;
        for (int i = l; i <= r - 1; i++) {
            if (arr[i] <= pivot) {
                idx++;
                swap(arr, idx, i);
            }
        }

        swap(arr, idx + 1, r);
        return (idx + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void EIUMEDARRAY4() {
    }

    public static void EIAPPLEBOX() {
    }

    private static final class OptimizedReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public OptimizedReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public OptimizedReader(FileInputStream stream) {
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
