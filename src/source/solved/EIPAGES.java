package solved;


import java.io.*;
import java.util.*;

class EIPAGES {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = ni();
        int[] arrNums = new int[n];
        for (int i = 0; i < n; i++) {
            arrNums[i] = ni();
        }

        Arrays.sort(arrNums);

        int start = arrNums[0];
        int end = arrNums[0];

        for (int i = 1; i < n; i++) {
            if (arrNums[i] == end + 1) {
                end = arrNums[i];
            } else {
                if (start == end) {
                    sb.append(start).append(" ");
                } else if (end - start == 1) {
                    sb.append(start).append(" ").append(end).append(" ");
                } else {
                    sb.append(start).append("-").append(end).append(" ");
                }

                start = arrNums[i];
                end = arrNums[i];
            }
        }

        if (start == end) {
            sb.append(start).append(" ");
        } else if (end - start == 1) {
            sb.append(start).append(" ").append(end).append(" ");
        } else {
            sb.append(start).append("-").append(end).append(" ");
        }
        System.out.println(sb);
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
