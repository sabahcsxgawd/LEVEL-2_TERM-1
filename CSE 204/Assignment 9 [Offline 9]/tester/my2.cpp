#include <bits/stdc++.h>
using namespace std;
#define pi acos(-1.0)
#define pb push_back
#define mp make_pair
#define ll long long
#define all(x) x.begin(),x.end()
#define rall(x) x.rbegin(),x.rend()
#define testcase ll T; cin >> T; for (ll tc = 1; tc <= T; tc++)
#define M 1000000007
#define MM 998244353
#define eps 1e-8
#define eq(x,y) (fabs((x)-(y)) < eps)
#define r2 1.41421356237
ll powmod(ll a,ll b,ll mod) {ll res=1;a%=mod;assert(b>=0); for(;b;b>>=1){if(b&1)res=res*a%mod;a=a*a%mod;}return res;}
ll gcd(ll a,ll b) { return b?gcd(b,a%b):a;}

bool is_pow2(int x)
{
    return (x > 0) && !(x & (x - 1));
}

int main()
{
  ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  testcase {
  int n;
    cin >> n;
    int cost[n][n] = {};

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> cost[i][j];
        }
    }

    int dp[1 << n][n] = {};

    for (int i = 0; i < n; i++)
    {
        dp[(1 << i)][i] = cost[i][i]; // if visited is pow of 2 then only 1 city visited; base case
    }

    for (int visited = 1; visited < (1 << n); visited++) // visited -> set of visited cities
    {
        for (int last = 0; last < n; last++) // last -> last city in visited set
        {
            if (visited & (1 << last)) // if last is included in visited then do further
            {

                int prev = visited - (1 << last); // prev -> set of visited cities excluding last

                if (!is_pow2(visited)) // if visited is not pow of 2 then
                {
                    dp[visited][last] = INT_MAX; // need to find the optimal ans for visited with last
                }                                // so initially ans is infinity

                for (int v = 0; v < n; v++)         // now for every last city in prev which is v we need to calculate
                {                                   // dp[visited][last] using dp[prev][v]
                    if (prev & (1 << v))            // dp[visited][last] = min cost to visit the visited set as last
                    {                               // being the last city in visited
                        int cur_cost = dp[prev][v]; // dp[visited][last] = dp[prev][v] + sum of cost[last][u]
                        for (int u = 0; u < n; u++) // where u represents cities belonging to visited
                        {                           // that also includes last so that cost also get calculated
                            if (visited & (1 << u))
                            {
                                cur_cost += cost[last][u];
                            }
                        }
                        dp[visited][last] = min(dp[visited][last], cur_cost); // storing min cost
                    }
                }
            }
        }
    }

    int all = (1 << n) - 1, ans = INT_MAX;

    for (int i = 0; i < n; i++)
    {
        ans = min(ans, dp[all][i]); // ans is the minimum of every city as last city in the visited set
    }                               // where visited is complete with all given cities

    if(n == 0) {
        ans = 0;
    }

    cout << ans << '\n';
  }
  return 0;
}

/*

*/