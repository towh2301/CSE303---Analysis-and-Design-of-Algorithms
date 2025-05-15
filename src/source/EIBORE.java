
import java.io.*;
import java.util.*;

class EIBORE {

    public static void main(String[] args) {
        int n = ni();
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = ni();
            myMap.put(temp, myMap.getOrDefault(temp, 0) + 1);
        }
        int[] dp = new int[myMap.size() + 1];

        int index = 0;
        int[] tempArr = new int[myMap.size()];
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            tempArr[index] = entry.getKey();
            index++;
        }
        Arrays.sort(tempArr);
        dp[1] = tempArr[0] * myMap.get(tempArr[0]);
        for (int i = 2; i < tempArr.length + 1; i++) {
            if (tempArr[i - 1] - tempArr[i - 2] == 1) {
                dp[i] = dp[i - 2] + tempArr[i - 1] * myMap.get(tempArr[i - 1]);
            } else {
                dp[i] = dp[i - 1] + tempArr[i - 1] * myMap.get(tempArr[i - 1]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[myMap.size()]);
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

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
