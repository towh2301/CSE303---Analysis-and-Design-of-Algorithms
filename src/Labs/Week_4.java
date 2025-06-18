package Labs;

import java.util.*;

public class Week_4 {
    private static final OptimizedReader reader = new OptimizedReader(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        //EIUSUBSET();
        //EIUQBHV();
        //EISUBSET2();
        //EIEQUALS();
        EIUDEPRE();

    }

    public static void EIUSUBSET() {
        sb = new StringBuilder();
        List<Double> numbers = new ArrayList<>();
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(reader.nextDouble());
        }

        int subsets = (int) Math.pow(2, n) - 1;

        bitMask(numbers, subsets);

        System.out.println(subsets);
        System.out.println(sb);

    }

    public static void bitMask(List<Double> numbers, int numOfSetsNumbers) {
        for (int i = 1; i < numOfSetsNumbers + 1; i++) {
            String temp = Integer.toBinaryString(i);
            while (temp.length() < numbers.size()) {
                temp = "0" + temp;
            }

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    sb.append(Math.round(numbers.get(j))).append(" ");
                }
            }
            sb.append("\n");
        }
    }

    public static void EIUQBHV() {
        sb = new StringBuilder();
        String letter = reader.next();

        TreeSet<String> passwords = new TreeSet<>();
        passwords.add(String.valueOf(letter.charAt(0)));

        for (int i = 1; i < letter.length(); i++) {
            TreeSet<String> subPasswords = new TreeSet<>();

            for (String pass : passwords) {
                for (int j = 0; j <= pass.length(); j++) {
                    String newSubPass = pass.substring(0, j) + letter.charAt(i) + pass.substring(j);
                    subPasswords.add(newSubPass);
                }
            }
            passwords = subPasswords;
        }

        sb.append(passwords.size()).append("\n");
        for (String pass : passwords) {
            sb.append(pass).append("\n");
        }
        System.out.println(sb);
    }

    public static void EISUBSET2() {
        sb = new StringBuilder();
        List<Double> numbers = new ArrayList<>();
        int n = reader.nextInt();
        long sum = reader.nextLong();
        for (int i = 0; i < n; i++) {
            numbers.add(reader.nextDouble());
        }
        int numOfSetsNumbers = (int) Math.pow(2, n) - 1;

        bitMaskSum(numbers, numOfSetsNumbers, sum);
    }

    public static void bitMaskSum(List<Double> numbers, int numOfSets, long sum) {
        int count = 0;
        for (int i = 1; i <= numOfSets; i++) {
            long tempSum = 0;
            String temp = Integer.toBinaryString(i);
            while (temp.length() < numbers.size()) {
                temp = "0" + temp;
            }

            for (int j = 0; j < numbers.size(); j++) {
                if (temp.charAt(j) == '1') {
                    tempSum += numbers.get(j);
                }
            }
            count = tempSum == sum ? count + 1 : count;
        }

        System.out.println(count);
    }

    public static void EIFLIP() {
        // Todo implement this
    }

    public static void EIEQUALS() {
        int n = reader.nextInt();
        int k = reader.nextInt();

        HashMap<Integer, Integer> appearanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            appearanceMap.put(num, appearanceMap.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            appearanceMap.put(num, appearanceMap.getOrDefault(num, 0) - 1);
        }

        boolean isValid = true;
        for (Map.Entry<Integer, Integer> entry : appearanceMap.entrySet()) {
            if (Math.abs(entry.getValue()) > 1) {
                isValid = false;
                break;
            }
            if (Math.abs(entry.getValue()) == 1) {
                isValid = Math.abs(entry.getKey() - k) <= k;
                if (!isValid) {
                    break;
                }
            }
        }

        System.out.println(isValid ? "YES" : "NO");
    }

    public static void EIDIVIDE() {
        // Todo implement this
    }

    public static void EIUDEPRE() {
        int m = reader.nextInt();
        int n = reader.nextInt();
        int k = reader.nextInt();
        double low = 0.0, high = 1.0, mid = 0.0;

        while (high - low > 1e-7) {
            mid = (low + high) / 2;
            double value = n;
            double rate = mid;

            for (int i = 0; i < m; i++) {
                double currentRate = rate - rate * i / m;
                value = value - value * currentRate;
            }

            if (value > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.printf("%.7f\n", mid);
    }
}
