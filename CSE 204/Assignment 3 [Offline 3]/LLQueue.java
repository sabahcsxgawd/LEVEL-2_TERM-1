class Link<E> {
    private E element;
    private Link<E> next;
    private Link<E> prev;


    public Link(E element, Link<E> prevLink, Link<E> nextLink) {
        this.element = element;
        this.next = nextLink;
        this.prev = prevLink;
    }

    public Link(Link<E> prevLink, Link<E> nextLink) {
        this.next = nextLink;
        this.prev = prevLink;
    }

    public Link<E> getNext() {
        return this.next;
    }

    public void setNext(Link<E> nextLink) {
        this.next = nextLink;
    }

    public Link<E> getPrev() {
        return this.prev;
    }

    public void setPrev(Link<E> prevLink) {
        this.prev = prevLink;
    }

    public E getElement() {
        return this.element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}


public class LLQueue<E> implements QueueADT<E> {

    private Link<E> front;
    private Link<E> rear;
    private int size;

    public LLQueue() {
        this.front = this.rear = new Link<E>(null, null);
        this.size = 0;
    }

    @Override
    public void clear() {
        this.front = this.rear = new Link<E>(null, null);
        this.size = 0;
    }

    @Override
    public void enqueue(E item) {
        Link<E> temp = new Link<E>(item, this.rear, null);
        this.rear.setNext(temp);
        this.rear = temp;
        this.size++;
    }

    @Override
    public E dequeue() {
        if (this.size == 0) {
            System.out.println("Can not dequeue from empty queue");
            return null;
        }
        E temp = this.front.getNext().getElement();
        if (this.size == 1) {
            this.front.setNext(null);
            this.rear = this.front;
        } else {
            this.front.getNext().getNext().setPrev(this.front);
            this.front.setNext(this.front.getNext().getNext());
        }
        this.size--;
        return temp;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public E frontValue() {
        if (this.size == 0) {
            System.out.println("No front value in empty queue");
            return null;
        }
        return this.front.getNext().getElement();
    }

    @Override
    public E rearValue() {
        if (this.size == 0) {
            System.out.println("No rear value in empty queue");
            return null;
        }
        return this.rear.getElement();
    }

    @Override
    public E leaveQueue() {
        if (this.size == 0) {
            System.out.println("Can not leave queue from empty queue");
            return null;
        }
        E temp = this.rear.getElement();
        this.rear = this.rear.getPrev();
        this.rear.setNext(null);
        this.size--;
        return temp;
    }
}
