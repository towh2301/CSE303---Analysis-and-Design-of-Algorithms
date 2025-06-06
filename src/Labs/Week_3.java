package Labs;

import java.util.*;

public class Week_3 {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //EIPAIR();
        //EIULOVE();
        //EIUGIFTS();
        //EI2122Q1ADAM1();
        //EI2122Q1ADAM2();
    }

    public static void EIPAIR() {
        int n = reader.nextInt();
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = reader.nextInt();
            HashMap<Integer, Long> map = new HashMap<>();
            long sum = 0;
            for (int j = 0; j < k; j++) {
                int a = reader.nextInt();
                map.put(a, map.getOrDefault(a, 0L) + 1);
            }

            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                sum += ((long) entry.getValue() * (entry.getValue() - 1)) / 2;
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    public static void EIULOVE() {
        int n = reader.nextInt();
        int amount = reader.nextInt();
        int res = -1;

        for (int i = 0; i < n; i++) {
            int g = reader.nextInt();
            if (amount > g) {
                res = Math.max(res, g);
            }
        }
        System.out.println(res);
    }

    public static void EIUGIFTS() {
        int n = reader.nextInt();
        int amount = reader.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int diff = -1, sum = -1;
        while (i < j) {
            int tempSum = arr[i] + arr[j];
            int tempDiff = Math.abs(arr[i] - arr[j]);
            if (tempSum <= amount) {
                sum = tempSum;
                diff = tempDiff;
                i++;
            } else {
                j--;
            }
        }

        if (diff == -1) {
            System.out.println("-1 -1");
        } else {
            System.out.println(sum + " " + diff);
        }

    }

    public static void EI2122Q1ADAM1() {
        int n = reader.nextInt();
        int x = reader.nextInt();
        int count = 0;
        int[] arrNums = new int[n];
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arrNums[i] = reader.nextInt();
        }

        for (int num : arrNums) {
            count += myMap.getOrDefault(num - x, 0);
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(count);
    }

    public static void EI2122Q1ADAM2() {
        int n = reader.nextInt(), m = reader.nextInt(), x = reader.nextInt();
        Integer[] men = new Integer[n];
        Integer[] women = new Integer[m];

        for (int i = 0; i < n; i++) men[i] = reader.nextInt();
        for (int i = 0; i < m; i++) women[i] = reader.nextInt();

        Arrays.sort(men);
        Arrays.sort(women);

        int minPairs = Math.min(Math.min(n, m), x);
        int maxDiff = 0;

        for (int i = 0; i < minPairs; i++) {
            int diff = Math.abs(men[i] - women[i]);
            maxDiff = Math.max(maxDiff, diff);
        }

        System.out.println(maxDiff);
    }
}
