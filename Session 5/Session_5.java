import java.util.*;
import java.io.*;
public class Session_5 {

    public static int compare(Pair a , Pair b){
        if(a.x == b.x)
            return a.y - b.y;
        return a.x - b.x;
    }
    public static int compare2(Pair a , Pair b){
        if(a.x == b.x)
            return b.y - a.y;
        return a.x - b.x;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] arr = sc.nextIntArray(n);
//      ------------------------------HashSet---------------------------------
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1); //O(1)
        pw.println(hs.contains(1)); //O(1)
        hs.remove(1); //O(1)

        for (int i = 0; i < n; i++) hs.add(arr[i]);

        for (int x : hs) //traversing the HashSet
            pw.println(x);

//      ------------------------------HashMap---------------------------------
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 1); //O(1)
        pw.println(hm.containsKey(1)); //O(1)
        pw.println(hm.get(1)); //O(1)
        pw.println(hm.getOrDefault(2, 0));
        hm.remove(1); //O(1)

        for (int i = 0; i < n; i++) // HashMap with frequency
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

        for (int x : hm.keySet()) //traversing the HashMap
            pw.println(x + " " + hm.get(x));

        for (int x : hm.values()) //traversing only the values of the keys of the HashMap
            pw.println(x);

//      ------------------------------TreeSet---------------------------------
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0); //O(log(n))
        ts.add(1); //O(log(n))
        ts.add(2); //O(log(n))
        ts.add(3); //O(log(n))
        pw.println(ts.contains(1)); //O(log(n))
        pw.println(ts.higher(1)); // > 1 O(log(n))
        pw.println(ts.lower(1)); // < 1 O(log(n))
        pw.println(ts.ceiling(1)); // >= 1 O(log(n))
        pw.println(ts.floor(1)); // <= 1 O(log(n))
        pw.println(ts.first()); //smallest element in the treeSet O(log(n))
        pw.println(ts.last()); //largest element in the treeSet O(log(n))
        pw.println(ts.pollFirst()); //removes and returns the smallest element in the treeSet O(log(n))
        pw.println(ts.pollLast()); //removes and returns the largest element in the treeSet O(log(n))

        for (int x : ts) //traversing the TreeSet
            pw.println(x);

//      ------------------------------TreeMap---------------------------------
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(1, 1); //O(log(n))
        tm.put(2, 2); //O(log(n))
        tm.put(3, 3); //O(log(n))
        pw.println(tm.containsKey(1)); //O(log(n))
        pw.println(tm.get(1)); //O(log(n))
        pw.println(tm.higherKey(1)); // > 1 O(log(n))
        pw.println(tm.lowerKey(1)); // < 1 O(log(n))
        pw.println(tm.ceilingKey(1)); // >= 1 O(log(n))
        pw.println(tm.floorKey(1)); // <= 1 O(log(n))
        pw.println(tm.firstKey()); //smallest element in the treeMap O(log(n))
        pw.println(tm.lastKey()); //largest element in the treeMap O(log(n))
        pw.println(tm.pollFirstEntry()); //removes and returns the smallest element in the treeMap O(log(n))
        pw.println(tm.pollLastEntry()); //removes and returns the largest element in the treeMap O(log(n))

        for (int x : tm.keySet()) //traversing the TreeMap
            pw.println(x + " " + tm.get(x));

//        ------------------------------PriorityQueue---------------------------------
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1); //O(log(n))
        pq.add(2); //O(log(n))
        pq.add(3); //O(log(n))
        pw.println(pq.peek()); //returns the smallest element in the priorityQueue O(1)
        pw.println(pq.poll()); //removes and returns the smallest element in the priorityQueue O(log(n))
        pw.println(pq.contains(1)); //O(n)
        pq.remove(1); //O(n)
        while(!pq.isEmpty()) //traversing the pq O(nlog(n))
            pw.println(pq.poll());

//      ------------------------------Sorting with different criteria------------------

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //sorts in descending order
        PriorityQueue<Pair> pq3 = new PriorityQueue<>(); // sorting the pq according to the compareTo methode in the Pair class
        PriorityQueue<Pair> pq4 = new PriorityQueue<>((a , b) -> (a.x == b.x ? a.y - b.y : a.x - b.x)); // sorting the pq according to the lambda expression
        PriorityQueue<Pair> pq5 = new PriorityQueue<>((a , b) -> compare(a , b)); // sorting the pq according to the compare methode
        PriorityQueue<Pair> pq6 = new PriorityQueue<>((a , b) -> compare2(a , b)); // sorting the pq according to the compare2 methode

        // all of the above applies also with Arrays.Sort() as well as TreeSets and TreeMaps

        pw.flush();
    }

    static class Pair implements Comparable<Pair>{
        int x ,y;
        public Pair(int x , int y ){
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o) {
            if(this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }
        public String toString(){
            return "("+x+" "+y+")";
        }
    }
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
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

        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }

}