import java.io.*;
import java.util.*;

public class ConnectedComponents {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    static ArrayList<Integer>[] adjList;
    static ArrayList<ArrayList<Integer>> components;
    static ArrayList<Integer> comp;
    static boolean[] vis;

    public static void dfs(int node) {
        vis[node] = true;
        comp.add(node);
        for (int neighbour : adjList[node]) {
            if (!vis[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        adjList = new ArrayList[n];
        vis = new boolean[n];
        components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // a series of dfs's --> time is O(N + M) as each node is visited at most once
        // so it has the same time and space complexities as a single dfs
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                comp = new ArrayList<>();
                dfs(i);
                components.add(comp);
            }
        }

        pw.println(components);
        pw.close();
    }
}

