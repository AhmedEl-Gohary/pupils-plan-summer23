#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n;
    cin >> n;
    vector<vector<int>> g(n);
    for (int i = 1; i < n; i++) {
        int p;
        cin >> p, p--;
        g[p].push_back(i);
        g[i].push_back(p);
    }
    vector<int> col(n);
    for (int i = 0; i < n; i++) {
        char c;
        cin >> c;
        if (c == 'B') col[i] = 1;
        else col[i] = -1;
    }
    int ans = 0;
    vector<int> sum(n);
    function<void(int, int)> dfs = [&](int v, int p) {
        sum[v] += col[v];
        for (int u : g[v]) {
            if (u == p) continue;
            dfs(u, v);
            sum[v] += sum[u];
        }
        if (sum[v] == 0) ans++;
    };
    dfs(0, -1);
    cout << ans << "\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) solve();
}
