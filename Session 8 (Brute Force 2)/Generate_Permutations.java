import java.io.*;
import java.util.*;

public class Generate_Permutations {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	static int n;
	static int arr[];
//	static boolean vis[];

	// generating all permutations and store result in array
	public static void genPerms(int idx, int mask, int res[]) {
		if (idx == n) { // base case (leaf of recursion tree)
			for (int i = 0; i < n; i++) {
				pw.print(res[i] + " ");
			}
			pw.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				res[idx] = arr[i];
				genPerms(idx + 1, mask | (1 << i), res);
			}
		}
	}

	// generate all permutations and store result in LinkedList
	public static void genPerms(int idx, int mask, LinkedList<Integer> res) {
		if (idx == n) {
			for (int x : res)
				pw.print(x + " ");
			pw.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				res.add(arr[i]);
				genPerms(idx + 1, mask | (1 << i), res);
				res.pollLast();
			}
		}
	}

	// generate all distinct permutations of an array eg {1, 2, 2, 3}
	public static void genPermsWithRepitition(int idx, int mask, int res[]) {
		if (idx == n) { // base case
			for (int x : res)
				pw.print(x + " ");
			pw.println();
			return;
		}
		HashSet<Integer> hs = new HashSet();
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0 && !hs.contains(arr[i])) {
				hs.add(arr[i]);
				res[idx] = arr[i];
				genPermsWithRepitition(idx + 1, mask | (1 << i), res);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		genPermsWithRepitition(0, 0, new int[n]);
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
