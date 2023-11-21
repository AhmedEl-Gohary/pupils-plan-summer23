import java.io.*;
import java.util.*;

public class DFS {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static boolean[][] adjMatrix;

    // time: O(N + M) where N is number of nodes, M is the number of edges
    // space: O(N)
    public static void dfsList(int node) {
        visited[node] = true;
        for (int neighbour : adjList[node]) {
            if (!visited[neighbour]) {
                dfsList(neighbour);
            }
        }
    }

    // time is always: O(N ^ 2) where N is the number of nodes
    // space: O(N)
    public static void dfsMatrix(int node) {
        visited[node] = true;
        for (int nxt = 0; nxt < adjMatrix.length; nxt++) {
            if (!visited[nxt] && adjMatrix[node][nxt]) {
                dfsMatrix(nxt);
            }
        }
    }

    public static void main(String[] args) {
        // n nodes and m edges
        int n = sc.nextInt(), m = sc.nextInt();

        // taking input graph as an adjacency list
        /* Note: if the graph is weighted we can store the graph as an
           array of array lists of pairs --> ArrayList<Pair>[] adjList
           and then to add edge u - v with weight w
           we say adjList[u].add(new Pair(v, w)) and (if undirected) adjList[v].add(new Pair(u, w))
        */
        adjList = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            adjList[u].add(v);
            adjList[v].add(u); // omit this line if the graph is directed
        }




        // taking input graph as an adjacency matrix
        /* Note: if the graph is weighted, instead of boolean[][] adjMatrix
           we will have int[][] adjMatrix
           and then to add edge u - v with weight w
           we say adjMatrix[u][v] = w and (if undirected) adjMatrix[v][u] = w
        */
        adjMatrix = new boolean[n][n];
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            u--;
            v--;
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true; // omit this line if the graph is directed
        }


        pw.close();
    }
}
