#include <bits/stdc++.h>

using namespace std;
using namespace std::chrono;

void insertion_sort(int *arr, int n);
void stl_sort(int *arr, int n);
void merge(int *arr, int l, int m, int r);
void merge_sort(int *arr, int l, int r);
int get_pivot_actual_index(int *arr, int l, int r);
int get_rand_pivot_actual_index(int *arr, int l, int r);
void quick_sort(int *arr, int l, int r);
void randomized_quick_sort(int *arr, int l, int r);
void gen_rand(int *arr, int n);
double get_merge_sort_time(int *arr, int n);
double get_insertion_sort_time(int *arr, int n);
double get_quick_sort_time(int *arr, int n);
double get_randomized_quick_sort_time(int *arr, int n);
double get_sorted_quick_sort_time(int *arr, int n);
double get_sorted_randomized_quick_sort_time(int *arr, int n);
double get_stl_sort_time(int *arr, int n);

void insertion_sort(int *arr, int n)
{
    for (int i = 1; i < n; i++)
    {
        int val = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > val)
        {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = val;
    }
}

void stl_sort(int *arr, int n)
{
    sort(arr, arr + n);
}

void merge(int *arr, int l, int m, int r)
{
    int leftArrSize = m - l + 1;
    int rightArrSize = r - m;
    int *leftArr, *rightArr;
    leftArr = new int[leftArrSize];
    rightArr = new int[rightArrSize];
    for (int i = 0; i < leftArrSize; i++)
    {
        leftArr[i] = arr[l + i];
    }
    for (int i = 0; i < rightArrSize; i++)
    {
        rightArr[i] = arr[m + 1 + i];
    }
    int indexLeftArr, indexRightArr, indexMergedArr;
    indexLeftArr = indexRightArr = 0;
    indexMergedArr = l;
    while (indexLeftArr < leftArrSize && indexRightArr < rightArrSize)
    {
        if (leftArr[indexLeftArr] <= rightArr[indexRightArr])
        {
            arr[indexMergedArr] = leftArr[indexLeftArr];
            indexLeftArr++;
        }
        else
        {
            arr[indexMergedArr] = rightArr[indexRightArr];
            indexRightArr++;
        }
        indexMergedArr++;
    }
    while (indexLeftArr < leftArrSize)
    {
        arr[indexMergedArr] = leftArr[indexLeftArr];
        indexLeftArr++;
        indexMergedArr++;
    }
    while (indexRightArr < rightArrSize)
    {
        arr[indexMergedArr] = rightArr[indexRightArr];
        indexRightArr++;
        indexMergedArr++;
    }
    delete[] leftArr;
    delete[] rightArr;
}

void merge_sort(int *arr, int l, int r)
{
    if (l < r)
    {
        int m = l + (r - l) / 2;
        merge_sort(arr, l, m);
        merge_sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

int get_pivot_actual_index(int *arr, int l, int r)
{
    int pivot = arr[r];
    int i = l - 1;
    for (int j = l; j < r; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(arr[i], arr[j]);
        }
    }
    i++;
    swap(arr[i], arr[r]);
    return i;
}

int get_rand_pivot_actual_index(int *arr, int l, int r)
{
    int rand_pivot_index = l + rand() / (RAND_MAX / (r - l + 1) + 1);
    swap(arr[rand_pivot_index], arr[r]);
    return get_pivot_actual_index(arr, l, r);
}

void quick_sort(int *arr, int l, int r)
{
    if (l < r)
    {
        int pivot = get_pivot_actual_index(arr, l, r);
        quick_sort(arr, l, pivot - 1);
        quick_sort(arr, pivot + 1, r);
    }
}

void randomized_quick_sort(int *arr, int l, int r)
{
    if (l < r)
    {
        int pivot = get_rand_pivot_actual_index(arr, l, r);
        randomized_quick_sort(arr, l, pivot - 1);
        randomized_quick_sort(arr, pivot + 1, r);
    }
}

void gen_rand(int *arr1, int *arr2, int *arr3, int *arr4, int *arr5, int n)
{
    for (int i = 0; i < n; i++)
    {
        arr1[i] = rand();
        arr2[i] = arr1[i];
        arr3[i] = arr1[i];
        arr4[i] = arr1[i];
        arr5[i] = arr1[i];
    }
}

double get_merge_sort_time(int *arr, int n)
{
    high_resolution_clock::time_point start, end;
    double time = 0.0;
    start = high_resolution_clock::now();
    merge_sort(arr, 0, n - 1);
    end = high_resolution_clock::now();
    time = duration_cast<milliseconds>(end - start).count();
    return time;
}

double get_insertion_sort_time(int *arr, int n)
{
    high_resolution_clock::time_point start, end;
    double time = 0.0;
    start = high_resolution_clock::now();
    insertion_sort(arr, n);
    end = high_resolution_clock::now();
    time = duration_cast<milliseconds>(end - start).count();
    return time;
}

double get_quick_sort_time(int *arr, int n)
{
    high_resolution_clock::time_point start, end;
    double time = 0.0;
    start = high_resolution_clock::now();
    quick_sort(arr, 0, n - 1);
    end = high_resolution_clock::now();
    time = duration_cast<milliseconds>(end - start).count();
    return time;
}

double get_randomized_quick_sort_time(int *arr, int n)
{
    high_resolution_clock::time_point start, end;
    double time = 0.0;
    start = high_resolution_clock::now();
    randomized_quick_sort(arr, 0, n - 1);
    end = high_resolution_clock::now();
    time = duration_cast<milliseconds>(end - start).count();
    return time;
}

double get_sorted_quick_sort_time(int *arr, int n)
{
    return get_quick_sort_time(arr, n);
}

double get_sorted_randomized_quick_sort_time(int *arr, int n)
{
    return get_randomized_quick_sort_time(arr, n);
}

double get_stl_sort_time(int *arr, int n)
{
    high_resolution_clock::time_point start, end;
    double time = 0.0;
    start = high_resolution_clock::now();
    stl_sort(arr, n);
    end = high_resolution_clock::now();
    time = duration_cast<milliseconds>(end - start).count();
    return time;
}

int main()
{
    srand(1905118);

    int n[] = {5, 10, 100, 1000, 10000, 100000};

    int n_size = sizeof(n) / sizeof(n[0]);

    double sorting_times[n_size][7] = {0.0};

    for (int i = 0; i < n_size; i++)
    {
        int *arrMS, *arrIS, *arrSTLS, *arrQS, *arrRQS;
        arrMS = new int[n[i]];
        arrIS = new int[n[i]];
        arrSTLS = new int[n[i]];
        arrQS = new int[n[i]];
        arrRQS = new int[n[i]];
        for (int j = 0; j < 20; j++)
        {
            gen_rand(arrMS, arrIS, arrSTLS, arrQS, arrRQS, n[i]);
            sorting_times[i][0] += get_merge_sort_time(arrMS, n[i]);
            sorting_times[i][1] += get_quick_sort_time(arrQS, n[i]);
            sorting_times[i][2] += get_randomized_quick_sort_time(arrRQS, n[i]);
            sorting_times[i][3] += get_insertion_sort_time(arrIS, n[i]);
            sorting_times[i][4] += get_sorted_quick_sort_time(arrQS, n[i]);
            sorting_times[i][5] += get_sorted_randomized_quick_sort_time(arrRQS, n[i]);
            sorting_times[i][6] += get_stl_sort_time(arrSTLS, n[i]);
        }
        delete[] arrMS;
        delete[] arrIS;
        delete[] arrSTLS;
        delete[] arrQS;
        delete[] arrRQS;
    }

    ofstream dataFile("1905118.csv");
    string row1 = "Time required in ms,,,,,,,";
    string row2 = "n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Input,STL sort() function";
    dataFile << row1 << '\n';
    dataFile << row2 << '\n';
    for (int i = 0; i < n_size; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            sorting_times[i][j] /= 20.0;
        }
        dataFile << fixed << setprecision(10) << n[i] << ',' << sorting_times[i][0] << ',' << sorting_times[i][1] << ',' << sorting_times[i][2] << ',' << sorting_times[i][3] << ',' << sorting_times[i][4] << ',' << sorting_times[i][5] << ',' << sorting_times[i][6];
        if (i != n_size - 1)
        {
            dataFile << '\n';
        }
    }
    dataFile.close();
    cout << "-----Success-----";
    return 0;
}