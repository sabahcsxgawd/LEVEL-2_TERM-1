public interface StackADT<E> {
    public void clear();
    public void push(E item);
    public E pop();
    public int length();
    public E topValue();
    public void setDirection(int direction);
}
