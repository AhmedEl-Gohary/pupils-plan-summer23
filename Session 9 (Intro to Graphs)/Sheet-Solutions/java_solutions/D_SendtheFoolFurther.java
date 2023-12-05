import java.io.*;
import java.util.*;
import java.math.*;

public class C {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Pair> adj[] = new ArrayList[100];
    static int ans = 0;
    static void dfs(int v , int p  , int cnt){
        ans = Math.max(ans , cnt);
        for (Pair i : adj[v]){
            if (i.first == p) continue;
            dfs(i.first , v , cnt+i.second);
        }
    }
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        for (int i = 0;i<n;i++) adj[i] = new ArrayList<>();
        for (int i = 0;i<n-1;i++){
            int u  = sc.nextInt(), v  = sc.nextInt(), w = sc.nextInt();
            adj[u].add(new Pair(v ,w));
            adj[v].add(new Pair(u ,w));
        }
        dfs(0 , -1 , 0);
        out.println(ans);
           out.close();
    }
    static long mod = (int) 998244353;
    static long countDiv(long n) {
        long cnt = 0;
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i)
                    cnt++;
                else
                    cnt = cnt + 2l;
            }
        }
        return cnt;
    }

    static long power(long x, long y, long mod)
    {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % mod;

            y = y >> 1;
            x = (x * x) % mod;
        }

        return res;
    }
    static long modInverse(long n, long p)
    {
        return power(n, p - 2, p);
    }
    static long nCrModPFermat(long n, long r)
    {

        if (n<r)
            return 0;
        if (r == 0)
            return 1;
        long[] fac = new long[(int)n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % mod;

        return (fac[(int)n] * modInverse(fac[(int)r], mod)
                % mod * modInverse(fac[(int)n - (int)r], mod)
                % mod)
                %mod ;
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair p) {
            if (first != p.first)
                return Long.compare(first, p.first);
            else if (second != p.second)
                return Long.compare(second, p.second);
            else
                return 0;
        }

        public String toString() {
            return this.first + " "+ this.second;
        }
    }

    static long fact(long n) {
        long ans = 1;
        for (int i = 1;i<=n;i++) {
            ans = (ans%mod * i%mod)%mod;
        }
        return ans;
    }


    static long fastPower(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long a2 = fastPower(a, n / 2);
        long res = a2 * a2 % mod * (n % 2 == 1 ? a : 1);
        return res % mod;
    }

    static class Tuple implements Comparable<Tuple> {
        long first;
        long second;
        long third;

        public Tuple(long a, long b, long c) {
            first = a;
            second = b;
            third = c;
        }

        public int compareTo(Tuple t) {
            if (first != t.first)
                return Long.compare(first, t.first);
            else if (second != t.second)
                return Long.compare(second, t.second);
            else if (third != t.third)
                return Long.compare(third, t.third);
            else
                return 0;
        }
    }

    static final Random random = new Random();

    static void shuffleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(n), temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(f));
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

    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static String concat(String s1, String s2) {
        return new StringBuilder(s1).append(s2).toString();
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
