package Question1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class EIAPPLEBOX {

    public static void main(String[] args) {
        int T = ni();
        for (int i = 0; i < T; i++) {

            int N = ni();
            long A = ni();
            long P = ni();

            long[] array = new long[N];

            array[0] = ((A * A) % P);
            for (int j = 1; j < N; j++) {
                array[j] = (array[j - 1] * A % P);
            }

            System.out.println(sort(array, 0, N - 1));
        }

    }

     static long merge(long arr[], int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        long L[] = new long[n1];
        long R[] = new long[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;

        int temp = left;
        int count = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[temp] = L[i];
                i++;
            } else {
                arr[temp] = R[j];
                j++;
                count += (mid + 1) - (left + i);
            }
            temp++;
        }

        while (i < n1) {
            arr[temp] = L[i];
            i++;
            temp++;
        }

        while (j < n2) {
            arr[temp] = R[j];
            j++;
            temp++;
        }

        return count;

    }

     static long sort(long[] array, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += sort(array, left, mid);
            count += sort(array, mid + 1, right);
            count += merge(array, left, mid, right);

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
