import java.io.*;
import java.util.*;

public class B_EvalExpression {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static int n, x;
    static int[] a;

    public static int precedence(char c) {
        if (c == '+' || c == '-') return 0;
        return 1;
    }

    public static long apply(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return 0;
    }

    public static long eval(String s) {
        // we need to take care of precedence of * over the other operators
        // we can use two stacks, one for the values and one for the operators

        // 10

        Stack<Long> vals = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            long val = 0;
            // s.chaarAt(i) >= '0' && s.charAt(i) <= '9'
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                val = (val * 10) + s.charAt(i) - '0';
                i++;
            }
            vals.push(val);
            if (i < s.length()) {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(s.charAt(i))) {
                    long b = vals.pop();
                    long a = vals.pop();
                    // a op b
                    char op = ops.pop();
                    vals.push(apply(a, b, op));
                }
                ops.push(s.charAt(i));
            }
        }

        while (!ops.isEmpty()) {
            long b = vals.pop();
            long a = vals.pop();
            char op = ops.pop();
            vals.push(apply(a, b, op));
        }
        return vals.peek();
    }

    public static boolean solve(int i, String cur) {
        if (i == n - 1) {
            cur += a[i];
            return (eval(cur) == x);
        }
        cur += a[i];
        return solve(i + 1, cur + "+") || solve(i + 1, cur + "-") || solve(i + 1, cur + "*");
    }

    public static void main(String[] args) throws Exception {
        // between every two adjacent numbers, try to recursively place any of the three operators
        // at the end, we will have an expression and we need evaluate it to check if it is equal to x
        n = sc.nextInt();
        x = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        pw.println(solve(0, "") ? "Yes" : "No");
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