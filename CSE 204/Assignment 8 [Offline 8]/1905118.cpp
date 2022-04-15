#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N, K;  // N -> number of plants , K -> number of friends

    cin >> N >> K;

    int *plant_prices = new int[N];

    for (int i = 0; i < N; i++)
    {
        cin >> plant_prices[i];
    }

    sort(plant_prices, plant_prices + N, greater<int>());  // Time complexity O(nlogn)

    long long min_cost = 0; // long long due to overflow in corner case

    for (int i = 0; i < N; i++)
    {
        // we need to assign higher price plants to those who have bought less previously
        min_cost += (((i / K) + 1) * plant_prices[i]);
    }

    cout << min_cost;

    delete[] plant_prices;

    return 0;
}
