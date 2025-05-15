package solved;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EIPAINTING {
    
    public static void main(String[] args) {
        int a = ni();
        Map<Integer, Integer> myMap = new TreeMap<>();
        for (int i = 0; i < a; i++) {
            int b = ni();
            if (myMap.get(b) != null) {
                myMap.put(b, myMap.get(b) + 1);
            } else {
                myMap.put(b, 1);
            }
        }
        List<Integer> entryList = new ArrayList<>(myMap.values());
        entryList.sort((e1, e2) -> e2.compareTo(e1));
        System.out.println(a - entryList.get(0));
        
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
