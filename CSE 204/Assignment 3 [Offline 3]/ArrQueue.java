public class ArrQueue<E> implements QueueADT<E> {

    private static final int defaultSize = 10;
    private int front;
    private int rear;
    private int maxSize;
    private E[] queueArray;

    public ArrQueue() {
        this(defaultSize);
    }

    public ArrQueue(int size) {     //empty size ; we cant double up
        this.front = 1;
        this.rear = 0;
        this.maxSize = size + 1;
        this.queueArray = (E[]) new Object[size + 1];
    }

    public ArrQueue(E[] arr) {    //empty arr; we cant double up
        this.front = 1;
        this.rear = arr.length - 1;
        this.maxSize = this.rear + 1;
        this.queueArray = arr;
    }

    private void increaseQueue() {                                          // a bit tricky
        E[] temp = (E[]) new Object[this.maxSize + this.maxSize - 1];
        for (int i = 0; i < this.length(); i++) {
            temp[i + this.front] = this.queueArray[(i + this.front) % this.maxSize];
        }
        this.rear = this.front + this.length() - 1;
        this.maxSize += this.maxSize - 1;
        this.queueArray = temp;
    }

    @Override
    public void clear() {
        this.front = 1;
        this.rear = 0;
    }

    @Override
    public void enqueue(E item) {
        if (this.length() == this.maxSize - 1) {
            increaseQueue();
        }
        this.rear = (this.rear + 1) % this.maxSize;
        this.queueArray[this.rear] = item;
    }

    @Override
    public E dequeue() {
        if (this.length() == 0) {
            System.out.println("Can not dequeue from empty queue");
            return null;
        }
        E temp = this.queueArray[this.front];
        this.front = (this.front + 1) % this.maxSize;
        return temp;
    }

    @Override
    public int length() {
        return (this.rear - this.front + 1 + this.maxSize) % this.maxSize;
    }

    @Override
    public E frontValue() {
        if (this.length() == 0) {
            System.out.println("No front value in empty queue");
            return null;
        }
        return this.queueArray[this.front];
    }

    @Override
    public E rearValue() {
        if (this.length() == 0) {
            System.out.println("No rear value in empty queue");
            return null;
        }
        return this.queueArray[this.rear];
    }

    @Override
    public E leaveQueue() {
        if (this.length() == 0) {
            System.out.println("Can not leave queue from empty queue");
            return null;
        }
        E temp = this.queueArray[this.rear];
        this.rear = (this.rear - 1 + this.maxSize) % this.maxSize;
        return temp;
    }
}
