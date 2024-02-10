import java.io.*;
import java.util.*;

public class DijkstraDense {
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
            u--;
            v--;
            adj[u].add(new Pair(w, v));
            adj[v].add(new Pair(w, u));
        }

        long inf = (long) 1e18;
        long[] dist = new long[n];
        boolean[] relaxed = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(dist, inf);

        dist[0] = 0;
        parent[0] = -1;

        // O(n^2 + m)
        for (int i = 0; i < n; i++) {
            // relax one node
            int nodeToRelax = 0;
            long minDist = inf;
            for (int j = 0; j < n; j++) {
                if (!relaxed[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    nodeToRelax = j;
                }
            }

            if (dist[nodeToRelax] == inf) break;

            relaxed[nodeToRelax] = true;

            for (Pair p : adj[nodeToRelax]) {
                long w = p.cost;
                int u = p.node;
                if (dist[nodeToRelax] + w < dist[u]) {
                    dist[u] = dist[nodeToRelax] + w;
                    parent[u] = nodeToRelax;
                }
            }

        }

        ArrayList<Integer> path = new ArrayList<>();
        for (int v = n - 1; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
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
