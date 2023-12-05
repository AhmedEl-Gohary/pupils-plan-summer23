#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n, m;
    cin >> n >> m;
    vector<map<int, vector<int>>> g(n);
    for (int i = 0; i < m; i++) {
        int u, v, c;
        cin >> u >> v >> c, u--, v--;
        g[u][c].push_back(v);
        g[v][c].push_back(u);
    }

    auto con = [&](int s, int e, int c) -> bool {
        vector<bool> vis(n);
        function<void(int)> dfs = [&](int v) {
            vis[v] = 1;
            if (!g[v].count(c)) return;
            for (int u : g[v][c]) {
                if (vis[u]) continue;
                dfs(u);
            }
        };
        dfs(s);
        return vis[e];
    };

    int q;
    cin >> q;
    while (q--) {
        int u, v;
        cin >> u >> v, u--, v--;
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += con(u, v, i);
        }
        cout << ans << "\n";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
}
