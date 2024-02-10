import java.io.*;
import java.util.*;

public class PrimsMinSpanningTree {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
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

        /*
            a better implementation than the one we discussed in the session
            it is very similar to dijkstra but instead of choosing the closest node from the source
            we choose the closest node to the whole tree we have built so far
         */

        long inf = (long) 1e18;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        boolean[] vis = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        int countNodes = 0;
        ArrayList<int[]> mst = new ArrayList<>();
        long totalWeight = 0;
        while (!pq.isEmpty()) {
            int v = pq.peek().v;
            long w = pq.poll().w;
            if (vis[v]) continue;
            vis[v] = true;
            if (parent[v] != -1) {
                int[] edge = {v, parent[v]};
                mst.add(edge);
            }
            countNodes++;
            totalWeight += w;
            for (Pair p : adj[v]) {
                if (!vis[p.v] && p.w < dist[p.v]) {
                    parent[p.v] = v;
                    dist[p.v] = p.w;
                    pq.add(new Pair(dist[p.v], p.v));
                }
            }
        }
        if (countNodes != n) {
            pw.println("NO MST");
        } else {
            pw.println(totalWeight);
            for (int[] edge : mst) {
                for (int v : edge) pw.print(v + 1 + " ");
                pw.println();
            }
        }
        pw.close();
    }

    static class Pair implements Comparable<Pair> {
        int v;
        long w;

        public Pair(long w, int v) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(w, p.w);
        }
    }
}