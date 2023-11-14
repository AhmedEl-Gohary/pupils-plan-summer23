import java.io.*;
import java.util.*;

public class A_Movies {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static int n, y, z;

    public static boolean recursiveTakeOrLeave(long[] a, int i, int cnt, long cur) {
        if (i == n) {
            // cur == (1l << y) - 1
            return (cnt == z && Long.bitCount(cur) == y);
        }
        boolean take = recursiveTakeOrLeave(a, i + 1, cnt + 1, cur | a[i]);
        boolean leave = recursiveTakeOrLeave(a, i + 1, cnt, cur);
        return take || leave;
    }

    public static boolean iterativeTakeOrLeave(long[] a) {
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != z) continue;
            long cur = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    cur |= a[i];
                }
            }
            if (Long.bitCount(cur) == y) {
                return true;
            }
        }
        return false;
    }


    public static void solve() throws IOException {
        n = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        // a[i] = the ith set represented as a long mask
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                int val  = sc.nextInt();
                a[i] |= (sc.nextLong() << j);
            }
        }
        // [12, 11, 3, ..]

        // do take or leave, where you take exactly z masks
        pw.println(iterativeTakeOrLeave(a) ? "YES" : "NO");
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