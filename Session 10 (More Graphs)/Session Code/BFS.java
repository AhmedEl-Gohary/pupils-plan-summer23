import java.io.*;
import java.util.*;

public class BFS {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    static int n, m;
    static ArrayList<Integer>[] adj;

    // Multi-Source BFS + finding the actual path from any of the sources to the destination

    static ArrayList<Integer> bfs(ArrayList<Integer> sources, int destination) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, -1);
        for (int s : sources) {
            dist[s] = 0;
            parent[s] = -1;
            q.add(s);
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : adj[v]) {
                if (dist[u] != -1) continue;
                dist[u] = 1 + dist[v];
                parent[u] = v;
                q.add(u);
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        for (int v = destination; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) throws Exception {
        n = sc.nextInt();
        m = sc.nextInt();
        int source = sc.nextInt(), destination = sc.nextInt();
        source--;
        destination--;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayList<Integer> sources = new ArrayList<>();
        sources.add(source);
        ArrayList<Integer> path = bfs(sources, destination);
        for (int x : path) {
            pw.print(x + 1 + " ");
        }
        pw.close();
    }
}