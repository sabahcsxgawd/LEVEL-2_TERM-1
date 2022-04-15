#include<bits/stdc++.h>

using namespace std;


int main() {

    vector<int> numbers;

    // reading from file begins. Loading all the numbers in the vector
    string myText;
    ifstream MyReadFile("numbers.txt");
    while (getline(MyReadFile, myText))
        numbers.push_back(atoi(myText.c_str()));
    MyReadFile.close();

    sort(numbers.rbegin(),numbers.rend());

    ofstream mf("ggg.txt");
    int len = numbers.size();
    for (int i = 0; i < len; i++)
    {
        mf << numbers[i] << '\n';
    }
    mf.close();

    return 0;
}
