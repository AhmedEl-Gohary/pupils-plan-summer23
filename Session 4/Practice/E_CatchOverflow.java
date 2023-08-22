import java.io.*;
import java.util.*;

public class E_CatchOverflow {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        int t = sc.nextInt();
        Stack<Long> st = new Stack<>();
        st.add(1L);
        long x = 0;
        long lim = (1L<<32) - 1;
        boolean flag = true;
        while (t-->0){
            String s = sc.next();
            if(s.equals("for")){
                long n =sc.nextInt();
                if (st.peek()*n > lim){
                    st.add(lim + 1);
                }else st.add(st.peek()*n);
            } else if (s.equals("end")) {
                st.pop();
            }else{
                x += st.peek();
                if(x > lim){
                    flag = false;
                }
            }
        }
        pw.println(flag?x:"OVERFLOW!!!");
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
