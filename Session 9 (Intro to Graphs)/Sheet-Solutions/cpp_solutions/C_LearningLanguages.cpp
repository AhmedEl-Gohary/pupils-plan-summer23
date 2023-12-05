#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n, m;
    cin >> n >> m;
    int bad = 0;
    vector<vector<int>> g(n + m);
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        if (k == 0) bad++;
        for (int j = 0; j < k; j++) {
            int x;
            cin >> x, x--;
            x += n;
            g[i].push_back(x);
            g[x].push_back(i);
        }
    }
    vector<bool> vis(n + m);
    function<void(int)> dfs = [&](int v) {
        vis[v] = 1;
        for (int u : g[v]) {
            if (vis[u]) continue;
            dfs(u);
        }
    };
    int ans = -1;
    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        dfs(i);
        ans++;
    }
    cout << ans + (bad == n);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
}
