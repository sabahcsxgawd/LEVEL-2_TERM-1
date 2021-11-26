public class AList<E> implements ListADT<E> {

    private static final int defaultSize = 5;  //confused about its existence :'(
    private int chunkSize;
    private int maxSize;
    private int listSize;
    private int curr;
    private E[] listArray;

    //need constructors
    public AList(int size) {
        listArray = (E[]) new Object[size];
        maxSize = chunkSize = size;
        listSize = curr = 0;
    }

    public AList() {
        this(defaultSize);
    }

    public AList(int listSize, int maxSize, E[] arr) {
        this.listSize = listSize;
        this.maxSize = maxSize;
        this.chunkSize = maxSize;
        curr = 0;
        listArray = (E[]) new Object[maxSize];
        for (int i = 0; i < listSize; i++) {
            listArray[i] = arr[i];
        }

    }

    private void increaseList() {                       //helper function to increase list size
        maxSize += chunkSize;
        E[] temp = (E[]) new Object[maxSize];
        for (int i = 0; i < listSize; i++) {
            temp[i] = listArray[i];
        }
        listArray = temp;
    }

    @Override
    public void clear() {
        for(int i= 0;i<listSize;i++) {
            listArray[i] = null;
        }
        listArray = null;
        listSize = curr = 0;
    }

    @Override
    public void insert(E item) {
        if (listSize == maxSize) {
            increaseList();
        }
        for (int i = listSize; i > curr; i--) {
            listArray[i] = listArray[i - 1];
        }
        listArray[curr] = item;
        listSize++;
    }

    @Override
    public void append(E item) {
        if (listSize == maxSize) {
            increaseList();
        }
        listArray[listSize++] = item;
    }

    @Override
    public E remove() {
        if ((curr < 0 || curr >= listSize)) {
//            System.out.println("Invalid current position");
            return null;
        }
        E temp = listArray[curr];
        for (int i = curr; i < listSize - 1; i++) {
            listArray[i] = listArray[i + 1];
        }
        listSize--;
        if(curr == listSize && curr>0) {
            curr--;
        }
        return temp;
    }

    @Override
    public void moveToStart() {
        curr = 0;
    }

    @Override
    public void moveToEnd() {
        curr = listSize - 1;
    }

    @Override
    public void prev() {
        if (curr != 0) {
            curr--;
        } else {
//            System.out.println("No previous element found");
        }
    }

    @Override
    public void next() {
        if (curr < listSize - 1) {
            curr++;
        } else {
//            System.out.println("No next element found");
        }
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        return curr;
    }

    @Override
    public void moveToPos(int pos) {
        if ((pos < 0) || (pos >= listSize)) {
            System.out.println("Position out of range");
        } else {
            curr = pos;
        }
    }

    @Override
    public E getValue() {
        if ((curr < 0) || (curr >= listSize)) {
//            System.out.println("No element in current position");
            return null;
        }
        return listArray[curr];
    }

    @Override
    public int Search(E item) {
        int found = -1;
        for (int i = 0; i < listSize; i++) {
            if (listArray[i].equals(item)) {
                found = i;
                break;
            }
        }
        return found;
    }
}
