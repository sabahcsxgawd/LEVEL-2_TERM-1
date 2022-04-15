#include <bits/stdc++.h>

using namespace std;

int cost[10][10];

int getTotalCost(int n, int cities[])
{
    int totalCost = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            totalCost += cost[cities[i]][cities[j]];
        }
    }
    return totalCost;
}

int main()
{
    int tc;
    cin >> tc;
    while (tc--)
    {
        int n, minCost = INT_MAX;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cin >> cost[i][j];
            }
        }

        int cities[n] = {};
        for (int i = 0; i < n; i++)
        {
            cities[i] = i;
        }

        do
        {
            minCost = min(minCost, getTotalCost(n, cities));
        } while (next_permutation(cities, cities + n));

        if(n == 0) minCost = 0;

        cout << minCost << '\n';
    }

    return 0;
}