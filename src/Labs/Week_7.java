package Labs;

import java.io.*;
import java.util.*;

public class Week_7 {

    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        EIAPPLEBOX();
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
        int n = reader.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        int[] temp = new int[n];

        mergeSort(arr, temp, 0, n - 1);

        sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }

    public static void mergeSort(int[] arr, int[] temp, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(arr, temp, l, m);
        mergeSort(arr, temp, m + 1, r);
        merge(arr, temp, l, m, r);
    }

    public static void merge(int[] arr, int[] temp, int l, int m, int r) {
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            int nextValue;
            if (arr[i] < arr[j]) {
                nextValue = arr[i++];
            } else {
                nextValue = arr[j++];
            }
            temp[k++] = nextValue;
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (int h = 0; h < k; h++) {
            arr[l + h] = temp[h];
        }
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
        if (l >= r) {
            return;
        }

        // int pivot = partition(arr, l, r);
        int pivot = hoarePartition(arr, l, r);

        sort(arr, l, pivot);
        sort(arr, pivot + 1, r);

    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }

        ++i;
        swap(arr, i, r);
        return i;
    }

    public static int hoarePartition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left - 1, j = right + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                swap(arr, i, j);
            } else {
                return j;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void EIUMEDARRAY4() {
        sb = new StringBuilder();
        int t = reader.nextInt();

        while (t-- > 0) {
            int n = reader.nextInt();
            long a = reader.nextInt();
            long p = reader.nextLong();
            int k = reader.nextInt();

            // // Store data in queue
            // PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // // The first element
            // long current = (a * a) % p;
            // for (int i = 0; i < n; i++) {
            //     if (maxHeap.size() < k) {
            //         maxHeap.add(current);
            //     } else if (maxHeap.peek() > current) {
            //         maxHeap.poll();
            //         maxHeap.add(current);
            //     }
            //     current = (current * a) % p;
            // }
            long[] arr = new long[n];
            arr[0] = (a * a) % p;

            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }

            sb.append(find_k_th(arr, 0, n - 1, k - 1)).append("\n");
        }

        System.out.println(sb);
    }

    public static long find_k_th(long[] arr, int left, int right, int k) {
        if (left >= right) {
            return arr[left];
        }

        int pivotIdx = findKThPartition(arr, left, right);

        if (k == pivotIdx) {
            return arr[pivotIdx];
        } else if (k < pivotIdx) {
            return find_k_th(arr, left, pivotIdx - 1, k);
        } else {
            return find_k_th(arr, pivotIdx + 1, right, k);
        }
    }

    public static int findKThPartition(long[] arr, int left, int right) {
        int i = left - 1;
        long pivot = arr[right];

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }

        ++i;
        swap(arr, i, right);

        return i;
    }

    public static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void EIAPPLEBOX() {
        sb = new StringBuilder();
        int t = reader.nextInt();

        while (t-- > 0) {
            int n = reader.nextInt();
            long a = reader.nextInt();
            long p = reader.nextLong();

            long[] arr = new long[n];
            arr[0] = (a * a) % p;

            for (int i = 1; i < n; i++) {
                arr[i] = (arr[i - 1] * a) % p;
            }

            long temp[] = new long[arr.length];
            int count = countMergeSort(arr, temp, 0, arr.length - 1);

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static int countMergeSort(long[] arr, long[] temp, int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = (l + r) / 2;

            count += countMergeSort(arr, temp, l, mid);
            count += countMergeSort(arr, temp, mid + 1, r);
            count += countMerge(arr, temp, l, mid, r);
        }

        return count;
    }

    public static int countMerge(long[] arr, long[] temp, int l, int m, int r) {
        int i = l, j = m + 1, k = 0, count = 0;

        while (i <= m && j <= r) {
            long nextValue;
            if (arr[i] < arr[j]) {
                nextValue = arr[i++];
            } else {
                nextValue = arr[j++];
                count += (m - i + 1);
            }

            temp[k++] = nextValue;
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, l, k);

        return count;
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
