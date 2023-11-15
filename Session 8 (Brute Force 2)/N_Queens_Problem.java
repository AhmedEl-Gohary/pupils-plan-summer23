import java.io.*;
import java.util.*;

public class N_Queens_Problem {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	
	static int n;
	static int[] board;
	
	static boolean isSafeCell(int row, int col, int colMask, int rightDiagonalMask, int leftDiagonalMask) {
		// check columns
		if((colMask & (1<<col)) != 0) 
			return false;
		// check right diagonal
		if((rightDiagonalMask & (1<<(row + col))) != 0) 
			return false;
		// check left diagonal
		if((leftDiagonalMask & (1<<(row + (n-1) - col))) != 0) 
			return false;
		return true;
	}
	
	static int countDifferentBoards(int row, int colMask, int rightDiagonalMask, int leftDiagonalMask) {
		if(row == n) {
			// print the board
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					pw.print((board[i] == j ? "Q" : ".") + " ");
				}
				pw.println();
			}
			pw.println();
			return 1;
		}
		int count = 0;
		for(int col = 0; col<n; col++) {
			if(isSafeCell(row, col, colMask, rightDiagonalMask, leftDiagonalMask)) {
				board[row] = col;
				int newColMask = colMask | (1<<col);
				int newRightDiagonalMask = rightDiagonalMask | (1<<(row + col));
				int newLeftDiagonalMask = leftDiagonalMask | (1<<(row + (n-1) - col));
				count += countDifferentBoards(row+1, newColMask, newRightDiagonalMask, newLeftDiagonalMask);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		board = new int[n];
		pw.println(countDifferentBoards(0, 0, 0, 0));
		pw.close();
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		long[] readArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

	}
}
