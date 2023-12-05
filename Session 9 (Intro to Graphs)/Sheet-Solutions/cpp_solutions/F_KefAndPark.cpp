#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n, m;
    cin >> n >> m;
    vector<int> cat(n);
    for (int i = 0; i < n; i++) cin >> cat[i];
    vector<vector<int>> g(n);
    for (int i = 1; i < n; i++) {
        int u, v;
        cin >> u >> v, u--, v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    int ans = 0;
    function<void(int, int, int, int)> dfs = [&](int v, int p, int cur, int mx) {
        if (cat[v]) cur++;
        else cur = 0;
        mx = max(mx, cur);

        if (v != 0 && g[v].size() == 1) {
            if (mx <= m) ans++;
        }
        for (int u : g[v]) {
            if (u == p) continue;
            dfs(u, v, cur, mx);
        }
    };
    dfs(0, -1, 0, 0);
    cout << ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
}
