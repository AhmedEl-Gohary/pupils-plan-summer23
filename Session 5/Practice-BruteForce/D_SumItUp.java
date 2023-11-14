import java.io.*;
import java.util.*;

public class D_SumItUp {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static int n, x;
    static int[] a;
    static ArrayList<ArrayList<Integer>> st;
    static ArrayList<Integer> list;

    public static void recursive(int i) {
        if (i == n) {
            int sum = 0;
            for (int val : list) sum += val;
            if (sum == x && !st.contains(list)) {
                st.add(new ArrayList<>(list));
            }
            return;
        }
        // leave
        recursive(i + 1);

        // take
        list.add(a[i]);
        recursive(i + 1);
        list.remove(list.size() - 1);
    }

    public static long iterative() {
        for (int mask = 0; mask < (1 << n); mask++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sub.add(a[i]);
                }
            }
            int sum = 0;
            for (int val : sub) sum += val;
            if (sum == x && !st.contains(sub)) {
                st.add(sub);
            }
        }
        return st.size();
    }

    public static void solve() throws IOException {
        n = sc.nextInt();
        x = sc.nextInt();
        a = new int[n];

        st = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        recursive(0);
        pw.println(st.size());
        //pw.println(iterative());
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
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