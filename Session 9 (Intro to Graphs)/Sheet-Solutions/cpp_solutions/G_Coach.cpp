#include <bits/stdc++.h>
using namespace std;
using ll = long long;

void solve() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> g(n);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v, u--, v--;
        g[u].push_back(v);
        g[v].push_back(u);
    }

    vector<bool> vis(n);
    vector<int> comp;
    function<void(int)> dfs = [&](int v) {
        vis[v] = 1;
        comp.push_back(v);
        for (int u : g[v]) {
            if (vis[u]) continue;
            dfs(u);
        }
    };


    vector<vector<vector<int>>> div(4);
    for (int i = 0; i < n; i++) {
        if (vis[i]) continue;
        comp.clear();
        dfs(i);
        if (comp.size() > 3) {
            cout << "-1\n";
            return;
        }
        div[comp.size()].emplace_back(comp);
    }

    vector<vector<int>> ans;
    for (const auto& arr : div[3]) {
        ans.push_back({arr[0] + 1, arr[1] + 1, arr[2] + 1});
    }

    int k = div[1].size() - div[2].size();
    if (k < 0 || k % 3 != 0) {
        cout << "-1\n";
        return;
    }
    for (const auto& arr : div[2]) {
        ans.push_back({arr[0] + 1, arr[1] + 1, div[1].back()[0] + 1});
        div[1].pop_back();
    }
    for (int i = 0; i < div[1].size(); i += 3) {
        ans.push_back({div[1][i][0] + 1, div[1][i + 1][0] + 1, div[1][i + 2][0] + 1});
    }

    for (const auto& arr : ans) {
        for (auto x : arr) cout << x << " ";
        cout << "\n";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
}
