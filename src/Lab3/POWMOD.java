package Lab3;

import java.util.Scanner;

public class POWMOD {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long x = sc.nextLong();
        long n = sc.nextLong();
        long k = sc.nextLong();

        System.out.println(powerMod(x, n, k));
    }

    public static Long powerMod(long x, long n, long k) {
        // (n*m) % k = n % k * m % k
        x = x % k;
        long res = 1;

        while (n > 0) {
            if (n % 2 != 0) {
                res = (res * x) % k;
            }

            n >>= 1;
            x = (x * x) % k;
        }

        return res;
    }

    // The visualize for x ^ y
    public static Long power(int x, int n) {
        /*
         *
         * x^y = x * x^(y-1) # if n is odd
         * x^y = [x^(y/2)]^2 # if n is even
         *
         * */
        var res = 1; // x ^ 0

        while (n > 0) {
            System.out.println("res: " + res);
            System.out.println("x: " + x);
            // n is odd
            // x^n = x * x^(y - 1)
            if (n % 2 != 0) {
                res *= x;
            }

            // Divine the exponential
            // Move bits of number to the right 1 bit => n = n / 2 ( 111 => 2^0 + 2^1 + 2^2 = 1 + 2 + 4 = 7)
            // n = 7 => n = n / 2 = 7 / 2 = 3 ( chia lấy nguyên ) => 111 => 11 (move 1 bit to the right) = 2^0 + 2^1 = 1 + 2 = 3
            n = n >> 1; // >> is move bit to the right

            // n is even
            // x^n = [x^(n/2)]^2 = x^(n/2) * x^(n/2)
            x *= x;

        }

        return (long) res;
    }
}
