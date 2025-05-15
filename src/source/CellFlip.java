import java.io.*;
import java.util.*;

class CellFlip {

  private static int n = 3;

  private static void flip(int[][] state, int r, int c) {
	state[r][c] = 1 - state[r][c];
	if (r > 0) {
	  state[r - 1][c] = 1 - state[r - 1][c];
	}
	if (r < n - 1) {
	  state[r + 1][c] = 1 - state[r + 1][c];
	}
	if (c > 0) {
	  state[r][c - 1] = 1 - state[r][c - 1];
	}
	if (c < n - 1) {
	  state[r][c + 1] = 1 - state[r][c + 1];
	}
  }

  private static int solveSingle(String[] grid) {
	int[][] target = new int[n][n];

	for (int i = 0; i < n; i++) {
	  for (int j = 0; j < n; j++) {
		target[i][j] = (grid[i].charAt(j) == '*') ? 1 : 0;
	  }
	}

	int minTaps = Integer.MAX_VALUE;

	for (int taps = 0; taps < 512; taps++) {
	  int[][] state = new int[n][n];
	  int tapCount = 0;

	  for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
		  if ((taps & (1 << (i * n + j))) != 0) {
			flip(state, i, j);
			tapCount++;
		  }
		}
	  }

	  boolean isMatch = true;
	  outerLoop:
	  for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
		  if (state[i][j] != target[i][j]) {
			isMatch = false;
			break outerLoop;
		  }
		}
	  }

	  if (isMatch) {
		minTaps = Math.min(minTaps, tapCount);
	  }
	}

	return minTaps;
  }

  public static void main(String[] args) {
	int t = ni();
	String[] grid = new String[3];

	while (t-- > 0) {
	  for (int i = 0; i < 3; i++) {
		grid[i] = ns();
	  }
	  int result = solveSingle(grid);
	  System.out.println(result);
	}
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
