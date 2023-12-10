import java.io.*;
import java.util.*;

public class TopologicalSort {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    // recursive Topological sort + cycle detection

    static ArrayList<Integer> order = new ArrayList<>();
    static ArrayList<Integer>[] adj;
    static int[] state;
    static int cycleStart = -1, cycleEnd = -1;
    static int[] parent;

    static boolean dfs(int v) {
        state[v] = 1;
        for (int u : adj[v]) {
            if (state[u] == 1) {
                cycleStart = u;
                cycleEnd = v;
                return true;
            } else if (state[u] == 0) {
                parent[u] = v;
                if (dfs(u)) return true;
            }
        }
        order.add(v);
        state[v] = 2;
        return false;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        adj = new ArrayList[n];
        state = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            // u -> v
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            adj[u].add(v);
        }

        boolean cyclic = false;
        for (int i = 0; i < n; i++) {
            if (state[i] == 2) continue;
            cyclic |= dfs(i);
        }

        if (cyclic) {
            ArrayList<Integer> cycle = new ArrayList<>();
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(cycleStart);
            Collections.reverse(cycle);
            pw.println("cyclic");
            for (int x : cycle) {
                pw.print(x + 1 + " ");
            }
        } else {
            Collections.reverse(order);
            for (int x : order) {
                pw.print(x + 1 + " ");
            }
        }

        // -----------------------------------------------------------------------------------
        // Iterative Topological Sort + detects if the graph was cyclic as a byproduct (i.e. topological order doesn't exist)

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indeg = new int[n];
        for (int i = 0; i < m; i++) {
            // u -> v
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            indeg[v]++;
            adj[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int v = q.poll();
            order.add(v);
            for (int u : adj[v]) {
                if (--indeg[u] == 0) {
                    q.add(u);
                }
            }
        }

        if (order.size() != n) {
            pw.println("The graph is cyclic");
        } else {
            for (int x : order) {
                pw.print(x + 1 + " ");
            }
        }
        pw.close();
    }
}
