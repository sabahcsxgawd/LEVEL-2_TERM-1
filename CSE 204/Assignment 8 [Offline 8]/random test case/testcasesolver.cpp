#include <bits/stdc++.h>

using namespace std;

int main()
{
    int testcase;
    ofstream dataF("output2.txt");
    ifstream readF("input2.txt");
    readF >> testcase;
    for (int j = 0; j < testcase; j++)
    {
        int N, K;

        readF >> N >> K;

        int *plant_prices = new int[N];

        for (int i = 0; i < N; i++)
        {
            readF >> plant_prices[i];
        }

        sort(plant_prices, plant_prices + N, greater<int>());

        long long ans = 0;

        for (int i = 0; i < N; i++)
        {
            ans += (((i / K) + 1) * plant_prices[i]);
        }

        dataF << ans;
        if (j != testcase - 1)
        {
            dataF << '\n';
        }

        delete[] plant_prices;
    }
    dataF.close();
    readF.close();

    cout << "SUCCESS";

    return 0;
}
