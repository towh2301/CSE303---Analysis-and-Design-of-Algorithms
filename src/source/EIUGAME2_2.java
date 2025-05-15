
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class EIUGAME2_2 {

    static InputReader sc;
    static final long MOD = 10000000;

    public static void main(String[] args) throws IOException {
        sc = new InputReader(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] dp = new long[m + 1];
        Arrays.fill(dp, Long.MIN_VALUE / 2);
        dp[0] = 0;
        dp[1] = 0;
        long[] count = new long[m + 1];
        Arrays.fill(count, 1);
        for (int i = 1; i <= n; i++) {
            dp[1] += sc.nextLong();
            for (int j = 2; j <= m; j++) {
                long current = sc.nextLong();
                long currentCount = count[j];
                if (dp[j] == dp[j - 1]) {
                    count[j] = (count[j - 1] + currentCount) % MOD;
                } else if (dp[j] < dp[j - 1]) {
                    count[j] = count[j - 1];

                }
                dp[j] = Math.max(dp[j], dp[j - 1]) + current;
            }
        }
        System.out.println(dp[m] + " " + count[m]);
    }

    static class InputReader {

        public int lenbuf = 0, ptrbuf = 0;
        public InputStream is;
        private byte[] inbuf = new byte[2 << 23];

        public InputReader(InputStream stream) throws IOException {
            is = stream;
            lenbuf = is.read(inbuf);
        }

        public InputReader(FileInputStream stream) throws IOException {
            is = stream;
            lenbuf = is.read(inbuf);
        }

        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                ptrbuf--;
                return true;
            }
            return false;
        }

        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
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

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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
}
