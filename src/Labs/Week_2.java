package Labs;

import java.util.*;

public class Week_2 {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static final StringBuilder sb = new StringBuilder();


    // For EIQUEENS
    // Define the sets to track the positions of queens
    static Set<Integer> rowsQueen = new HashSet<>();
    static Set<Integer> colsQueen = new HashSet<>();
    static Set<Integer> diag1Queen = new HashSet<>();
    static Set<Integer> diag2Queen = new HashSet<>();

    public static void main(String[] args) {
        // EIUGIFT1();
        // EIPAINTING();
        // EIQUEEN();
        // EISUBARRAY();
        // EIPAGES();
        // EIMIN();
    }

    public static void EIUGIFT1() {
//        Input:
//        4 4
//        2 3 2 4 (gift's sizes)
//        5 10 15 20 (wrapping paper)
//        Output:
//        2

        int n = reader.nextInt();
        int m = reader.nextInt();
        double[] giftSizes = new double[n];
        double[] wrappingPaper = new double[m];


        for (int i = 0; i < n; i++) {
            giftSizes[i] = reader.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            wrappingPaper[i] = reader.nextDouble();
        }

        Arrays.sort(giftSizes);
        Arrays.sort(wrappingPaper);

        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            double temp = wrappingPaper[j] / giftSizes[i];
            if (temp >= 2 && temp <= 3) {
                i++;
                j++;
                count++;
            } else if (temp > 3) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println(count);
    }

    public static void EIPAINTING() {
        int n = reader.nextInt();
        HashMap<Integer, Integer> beautyList = new HashMap();

        for (int i = 0; i < n; i++) {
            int m = reader.nextInt();
            beautyList.put(m, beautyList.getOrDefault(m, 0) + 1);
        }

        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : beautyList.entrySet()) {
            result = result < entry.getValue() ? entry.getValue() : result;
        }

        System.out.println(n - result);
    }

    public static void EIQUEEN() {

        // Diagonal 1: row - col (\)
        // Diagonal 2: row + col (/)
        int numOfQueens = 8;
        String[] board = new String[numOfQueens];

        for (int i = 0; i < numOfQueens; i++) {
            board[i] = reader.next();
            if (!EIQUEENS_CheckQueen(i, board[i].indexOf("*"))) {
                System.out.println("Invalid");
                return;
            }
        }

        System.out.println("Valid");
    }

    public static boolean EIQUEENS_CheckQueen(int row, int col) {
        if (rowsQueen.contains(row) || colsQueen.contains(col) || diag1Queen.contains(row - col) || diag2Queen.contains(row + col)) {
            return false;
        }

        rowsQueen.add(row);
        colsQueen.add(col);
        diag1Queen.add(row - col);
        diag2Queen.add(row + col);

        return true;
    }

    public static void EISUBARRAY() {
        int n = reader.nextInt();
        long max = 0;
        int sumPos = 0, sumNeg = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();

            sumPos += arr[i];
            sumNeg += arr[i];
            sumPos = Math.max(sumPos, 0);
            sumNeg = Math.min(sumNeg, 0);

            max = findMax(sumPos, sumNeg, max);
        }
        System.out.println(max);
    }

    public static long findMax(int sumPos, int sumNeg, long max) {
        max = Math.max(sumPos, max);
        max = Math.max(max, Math.abs(sumNeg));

        return max;
    }

    public static void EIPAGES() {
        int pages = reader.nextInt();
        List<Integer> pageNumbers = new ArrayList<>();
        List<List<Integer>> pagesList = new ArrayList<>();

        for (int i = 0; i < pages; i++) {
            pageNumbers.add(reader.nextInt());
        }

        Collections.sort(pageNumbers);

        for (int i = 0; i < pages; i++) {
            List<Integer> tempPages = new ArrayList<>();
            tempPages.add(pageNumbers.get(i));

            while (i + 1 < pages && pageNumbers.get(i + 1).equals(pageNumbers.get(i) + 1)) {
                tempPages.add(pageNumbers.get(i + 1));
                i++;
            }

            pagesList.add(tempPages);
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> tempPages : pagesList) {
            int size = tempPages.size();
            if (size > 2) {
                sb.append(tempPages.get(0)).append("-").append(tempPages.get(size - 1)).append(" ");
            } else if (size == 2) {
                sb.append(tempPages.get(0)).append(" ").append(tempPages.get(1)).append(" ");
            } else {
                sb.append(tempPages.get(0)).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void EIMIN() {
        int n = reader.nextInt();
        int k = reader.nextInt();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(reader.nextInt());
        }

        if(set.first() == 0) set.remove(0);
        List<Integer> sortedList = new ArrayList<>(set);

        int min = 0;
        int totalMin = 0;
        int size = sortedList.size();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++){
            if(i < size) {
                min = sortedList.get(i) - totalMin;
                sb.append(min).append("\n");
                totalMin += min;
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
