package Question1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

 class EIUMEDARRAY4 {

    static StringBuilder s = new StringBuilder();

    public static void main(String[] args) {
        int T = ni();

        for (int t = 0; t < T; t++) {
            long N = nl();
            long A = nl();
            long P = nl();
            long K = nl();

            long result = findKthSmallest(N, A, P, K);
            s.append(result).append("\n");
        }
        System.out.print(s);
    }

    private static long findKthSmallest(long N, long A, long P, long K) {
        long[] array = new long[(int) N];
        array[0] = (A * A) % P;
        for (int i = 1; i < N; i++) {
            array[i] = (array[i - 1] * A) % P;
        }
        long low = 0;
        long high = P;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(array, mid) < K) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static long count(long[] array, long value) {
        long count = 0;
        for (long element : array) {
            if (element <= value) {
                count++;
            }
        }
        return count;
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static float nf() {
        return Float.parseFloat(ns());
    }

    static int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    @SuppressWarnings("empty-statement")
    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
			;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    @SuppressWarnings("empty-statement")
    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

}
