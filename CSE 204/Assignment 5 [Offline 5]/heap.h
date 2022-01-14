using namespace std;

class Heap {

    private:
    int *arr;
    int maxSize;
    int left(int i) {
        return (i << 1);
    }
    int right(int i) {
        return (i << 1) | 1;
    }
    int parent(int i) {
        return (i >> 1);
    }
    void maxHeapify(int i) {
        int l = this -> left(i);
        int r = this -> right(i);
        int largest = i;
        if (l <= this -> arr[0] && this -> arr[l] > this -> arr[largest]) {
            largest = l;
        }
        if (r <= this -> arr[0] && this -> arr[r] > this -> arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(this -> arr[i], this -> arr[largest]);
            this -> maxHeapify(largest);
        }
    }
    void buildMaxHeap() {
        for (int i = (this -> arr[0]) >> 1; i > 0; i--) {
            this -> maxHeapify(i);
        }
    }
    Heap(const Heap & ob) {

    }
    void operator = (const Heap & ob) {

    }

    public:
    Heap(int size) {
            this -> arr = new int[size + 1];
            this -> arr[0] = 0;
            this -> maxSize = size;
        }
    Heap(const vector < int > & v) {
        this -> arr = new int[v.size() + 1];
        for (int i = 0; i < v.size(); i++) {
            this -> arr[i + 1] = v[i];
        }
        this -> arr[0] = v.size();
        this -> maxSize = v.size();
        this -> buildMaxHeap();
        }
    ~Heap() {
        delete[] this -> arr;
    }
    void insert(int value) {
        if (this -> arr[0] < this -> maxSize) {
            this -> arr[0]++;
            this -> arr[this -> arr[0]] = value;
            int temp = this -> arr[0];
            while (true) {
                if (this -> arr[temp] > this -> arr[this -> parent(temp)] && temp > 1) {
                    swap(this -> arr[temp], this -> arr[this -> parent(temp)]);
                    temp = this -> parent(temp);
                } else {
                    break;
                }
            }
        } else {
            cout << "No space for new keys\n";
        }
    }
    int getMax() {
        if (this -> arr[0] > 0) {
            return this -> arr[1];
        } else {
            cout << "No max key exists\n";
        }
    }
    void deleteKey() {
        if (this -> arr[0] > 0) {
            this -> arr[1] = this -> arr[this -> arr[0]];
            this -> arr[0]--;
            this -> maxHeapify(1);
        } else {
            cout << "No keys to delete\n";
        }
    }
    int size() {
        return this -> arr[0];
    }
};

void heapsort(vector < int > & v) {
    //ofstream mf("gg.txt");
    Heap temp(v);
    int n = temp.size();
    for (int i = 0; i < n; i++) {
        v[i] = temp.getMax();
        temp.deleteKey();
        //mf << v[i] << '\n';
        //cout << v[i] << '\n';
    }
    //mf.close();
    cout << "Sorted " << n << " numbers\n";
}
