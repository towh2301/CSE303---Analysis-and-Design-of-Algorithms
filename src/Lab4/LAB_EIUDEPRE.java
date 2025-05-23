package Lab4;

import java.io.*;
import java.util.*;

class LAB_EIUDEPRE {

  public static void main(String[] args) {
    int a = ni();
    int b = ni();
    int c = ni();
    double left = 0.0, right = 1.0, mid = 0.0;

    while (right - left > 1e-7) {
      mid = (left + right) / 2;
      double value = b;
      double rate = mid;
      for (int i = 0; i < a; i++) {
        double currentRate = rate - rate * i / a;
        value = value - value * currentRate;
      }
      if (value > c) {
        left = mid;
      } else {
        right = mid;
      }
    }
    System.out.printf("%.6f\n", mid);
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
