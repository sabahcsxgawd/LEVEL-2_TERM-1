#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    // testcase {
    random_device device;
    mt19937 generator(69);
    uniform_int_distribution<int> dist1(2, 100), dist2(2, 1000000);
    ofstream dataF("input2.txt");
    int testcase = 1000;
    dataF << testcase << '\n';
    for (int j = 0; j < testcase; j++)
    {
        int N, K;
        N = dist1(generator);
        K = dist1(generator);
        dataF << N << " " << K << '\n';
        for (int i = 0; i < N; i++)
        {
            dataF << dist2(generator);
            if (i != N - 1)
            {
                dataF << " ";
            }
        }
        if (j != testcase - 1)
        {
            dataF << '\n';
        }
    }
    dataF.close();
    cout << "SUCCESS";
    //}
    return 0;
}

/*

*/