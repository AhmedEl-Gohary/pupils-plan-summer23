import java.io.*;
import java.util.*;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Integer>[] adj;
	static ArrayList<ArrayList<Integer>>[] comps = new ArrayList[4];
	static ArrayList<Integer> comp = new ArrayList<>();
	static boolean vis[];
	
	static void dfs(int node) {
		comp.add(node);
		vis[node] = true;
		for(int child: adj[node]) {
			if(vis[child]) continue;
			dfs(child);
		}
	}
	
	public static void main(String[] args) throws Exception {
		int n = sc.nextInt();
		int m = sc.nextInt();
		adj = new ArrayList[n+1];
		vis = new boolean[n+1];
		for(int i = 0; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i<4; i++) {
			comps[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		for(int i = 1; i<=n; i++) {
			if(vis[i]) continue;
			dfs(i);
			if(comp.size() > 3) {
				pw.println(-1);
				pw.close();
				return;
			}
			comps[comp.size()].add(comp);
			comp = new ArrayList<>();
		}
		if(comps[2].size() > comps[1].size()) {
			pw.println(-1);
			pw.close();
			return;
		}
		for(ArrayList<Integer> component: comps[3]) {
			for(int node: component) {
				pw.print(node + " ");
			}
			pw.println();
		}
		int i = 0;
		for(; i<comps[2].size(); i++) {
			for(int node: comps[2].get(i)) {
				pw.print(node + " ");
			}
			for(int node: comps[1].get(i)) {
				pw.print(node + " ");
			}
			pw.println();
		}
		for(;i<comps[1].size(); i+=3) {
			for(int j = 0; j<3; j++) {
				int node = comps[1].get(i+j).get(0);
				pw.print(node + " ");
			}
			pw.println();
		}
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



