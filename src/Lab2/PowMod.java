package Lab2;

import java.util.*;

class PowMod {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextInt();
        long n = sc.nextInt();
        long k = sc.nextInt();
        System.out.println(powerMod(a, n, k));
    }

    public static long powerMod(long a, long n, long k) {
        if (n == 0) return 1;

        long half = powerMod(a, n / 2, k);
        if (n % 2 == 0) {
            return (half * half) % k;
        } else {
            return (half * half % k * a % k) % k;
        }
    }
}
