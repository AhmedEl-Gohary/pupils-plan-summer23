import java.io.*;
import java.util.*;

public class H_NextAndPreviousMinproblem {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            int[] prevMin = new int[n];
            int[] nextMin = new int[n];
            Arrays.fill(prevMin, -1);
            Arrays.fill(nextMin, -1);
            Stack<Integer> next = new Stack<>(), prev = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (next.isEmpty()) next.add(i);
                else {
                    while (!next.isEmpty() && arr[i] < arr[next.peek()]) {
                        nextMin[next.pop()] = arr[i];
                    }
                    next.add(i);
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (prev.isEmpty()) prev.add(i);
                else {
                    while (!prev.isEmpty() && arr[i] < arr[prev.peek()]) {
                        prevMin[prev.pop()] = arr[i];
                    }
                    prev.add(i);
                }
            }
            for(int x: nextMin) pw.print(x + " ");
            pw.println();
            for (int x: prevMin) pw.print(x + " ");
            pw.println();
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