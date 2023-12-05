#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n;
    cin >> n;
    vector<vector<pair<int, int>>> g(n);
    for (int i = 1; i < n; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].emplace_back(v, w);
        g[v].emplace_back(u, w);
    }
    int ans = 0;
    function<void(int, int, int)> dfs = [&](int v, int p, int sum) {
        ans = max(ans, sum);
        for (const auto& [u, w] : g[v]) {
            if (u == p) continue;
            dfs(u, v, sum + w);
        }
    };
    dfs(0, -1, 0);
    cout << ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
}
