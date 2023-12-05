#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n, m;
    cin >> n >> m;
    vector<int> deg(n);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v, u--, v--;
        deg[u]++, deg[v]++;
    }
    int leaves = 0;
    for (int i = 0; i < n; i++) {
        if (deg[i] == 1) leaves++;
    }
    int x = n - leaves - 1; // 1 is the centre node
    int y = leaves / x;
    cout << x << " " << y << "\n";
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) solve();
}
