import java.io.*;
import java.util.*;


public class D_TheChildAndSet {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    public static int lowBit(int x) {
        return (x & (-x));
    }

    public static void main(String[] args) throws Exception {
        int sum = sc.nextInt(), limit = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = limit; i >= 1; i--) {
            int low = lowBit(i);
            if (low <= sum) {
                sum -= low;
                ans.add(i);
            }
        }
        if (sum == 0) {
            pw.println(ans.size());
            for (int x : ans) {
                pw.print(x + " ");
            }
        } else {
            pw.println(-1);
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
