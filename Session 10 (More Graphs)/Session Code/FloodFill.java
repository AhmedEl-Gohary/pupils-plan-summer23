import java.io.*;
import java.util.*;

public class FloodFill {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    static int n, m;
    static char[][] mat;
    static boolean[][] vis;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void dfs(int i, int j) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int r = i + dx[k];
            int c = j + dy[k];
            if (vis[r][c] || mat[r][c] == '#') continue;
            dfs(r, c);
        }
    }


    public static void main(String[] args) throws Exception {
        n = sc.nextInt();
        m = sc.nextInt();
        mat = new char[n + 2][m + 2];
        vis = new boolean[n + 2][m + 2];
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(mat[i], '#');
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mat[i][j] = sc.next().charAt(0);
            }
        }

        int comps = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (vis[i][j] || mat[i][j] == '#') continue;
                dfs(i, j);
                comps++;
            }
        }
        pw.println(comps);
        pw.close();
    }
}
