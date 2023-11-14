import java.io.*;
import java.util.*;

public class C_NonSquareEquation {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    public static int s(long x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        long n = sc.nextLong();
        // n = x^2 + s(x)*x which implies that x <= 1e9
        // which means that 1 <= s(x) <= 81 and we can try them all and try to solve the quadratic equation
        // a(x^2) + bx + c = 0
        // a is 1, b is s(x), c is -n
        long ans = Long.MAX_VALUE;
        for (int b = 1; b <= 81; b++) {
            long det = b * b + 4 * n;
            long SQRT = (long) Math.sqrt(det);
            if (SQRT * SQRT == det) {
                long x = (-b + SQRT) / 2;
                long y = (-b - SQRT) / 2;
                if (x > 0 && x * x + b * x - n == 0 && s(x) == b) {
                    ans = Math.min(ans, x);
                }
                if (y > 0 && y * y + b * y - n == 0 && s(y) == b) {
                    ans = Math.min(ans, y);
                }
            }
        }
        pw.println(ans == Long.MAX_VALUE ? -1 : ans);
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