import java.io.*;
import java.util.*;


public class B_WeNeedTheZero {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    // O(n * range of x) ~= 2e5 operations
    public static int bruteForce(int n, int[] a) {
        for (int x = 0; x < (1 << 8); x++) {
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = (a[i] ^ x);
            }
            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor ^= b[i];
            }
            if (xor == 0) {
                return x;
            }
        }
        return -1;
    }

    // O(n)
    public static int linearSolution(int n, int[] a) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= a[i];
        }
        if (n % 2 == 0) {
            return (xor == 0 ? 0 : -1);
        }
        return xor;
    }

    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            pw.println(linearSolution(n, a));
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
