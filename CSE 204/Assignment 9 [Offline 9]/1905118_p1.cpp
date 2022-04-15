#include <bits/stdc++.h>
using namespace std;

void get_lcs(string s1, string s2)
{
    int dp[s1.size() + 1][s2.size() + 1] = {};

    for (int i = 1; i <= s1.size(); i++)
    {
        for (int j = 1; j <= s2.size(); j++)
        {
            if (s1[i - 1] == s2[j - 1])
            {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else
            {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    cout << dp[s1.size()][s2.size()] << '\n';

    string lcs;

    int i = s1.size(), j = s2.size();

    while (i > 0 && j > 0)
    {
        if (s1[i - 1] == s2[j - 1])
        {
            lcs.push_back(s1[i - 1]);
            i--;
            j--;
        }
        else if (dp[i - 1][j] > dp[i][j - 1])
        {
            i--;
        }
        else
        {
            j--;
        }
    }

    reverse(lcs.begin(), lcs.end());

    cout << lcs;
}

int main()
{
    string s1, s2;
    cin >> s1 >> s2;
    get_lcs(s1, s2);
    return 0;
}