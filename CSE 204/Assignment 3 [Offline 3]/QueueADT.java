public interface QueueADT<E> {
    public void clear();

    public void enqueue(E item);

    public E dequeue();

    public int length();

    public E frontValue();

    public E rearValue();

    public E leaveQueue();
}
