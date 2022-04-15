#include <bits/stdc++.h>

using namespace std;

bool is_pow2(int x)
{
    return (x > 0) && !(x & (x - 1));
}

int main()
{

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
        dp[(1 << i)][i] = cost[i][i]; // if visited is pow of 2 then only 1 city visited; base case preprocessing
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

                int cur_cost = 0;

                for (int u = 0; u < n; u++) // where u represents cities belonging to visited
                {                           // that also includes last so that cost also get calculated
                    if (visited & (1 << u))
                    {
                        cur_cost += cost[last][u];
                    }
                }

                for (int v = 0; v < n; v++) // now for every last city in prev which is v we need to calculate
                {                           // dp[visited][last] using dp[prev][v]
                    if (prev & (1 << v))    // dp[visited][last] = min cost to visit the visited set as last
                    {                       // being the last city in visited, cur_cost = sum of cost[last][u]
                                            // dp[visited][last] = dp[prev][v] + sum of cost[last][u]
                        dp[visited][last] = min(dp[visited][last], cur_cost + dp[prev][v]); // storing min cost
                    }
                }
            }
        }
    }

    int all = (1 << n) - 1, min_cost = INT_MAX;

    for (int i = 0; i < n; i++)
    {
        min_cost = min(min_cost, dp[all][i]); // ans is the minimum of every city as last city in the visited set
    }                                         // where visited is complete set with all given cities

    if (n == 0) // if no cities are given then there is no cost
    {
        min_cost = 0;
    }

    cout << min_cost; // Overall Time Complexity O(2^n * n^2)

    return 0;
}