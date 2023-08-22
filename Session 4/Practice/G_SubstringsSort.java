import java.io.*;
import java.util.*;

public class G_SubstringsSort {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i<n; i++) arr[i] = sc.next();
        Arrays.sort(arr, (s1,s2)->{
            return s1.length()-s2.length();
        });
        boolean flag = true;
        for (int i = 0; i<n-1; i++){
            flag &= arr[i+1].contains(arr[i]);
        }
        if(flag){
            pw.println("YES");
            for (String s: arr){
                pw.println(s);
            }
        }else pw.println("NO");

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