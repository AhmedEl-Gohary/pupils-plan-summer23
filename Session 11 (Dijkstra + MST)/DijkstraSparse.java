import java.io.*;
import java.util.*;

public class DijkstraSparse {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            adj[--u].add(new Pair(w, --v));
            adj[v].add(new Pair(w, u));
        }

        long inf = (long) 1e18;
        long[] dist = new long[n];
        int[] parent = new int[n];
        boolean[] relaxed = new boolean[n];
        Arrays.fill(dist, inf);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Pair(0, 0));


        while (!pq.isEmpty()) {
            int v = pq.poll().node;
            if (relaxed[v]) continue;
            relaxed[v] = true;
            for (Pair p : adj[v]) {
                int u = p.node;
                long w = p.cost;
                if (dist[v] + w < dist[u]) {
                    dist[u] = dist[v] + w;
                    pq.add(new Pair(dist[u], u));
                    parent[u] = v;
                }
            }
        }

        if (dist[n - 1] == inf) {
            pw.println(-1);
            
        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int v = n - 1; v != 0; v = parent[v]) {
            path.add(v);
        }
        path.add(0);
        Collections.reverse(path);

        for (int x : path) pw.print(x + 1 + " ");
        pw.close();
    }

    static class Pair implements Comparable<Pair> {
        long cost;
        int node;

        public Pair(long cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(cost, p.cost);  
        }
    }

}
