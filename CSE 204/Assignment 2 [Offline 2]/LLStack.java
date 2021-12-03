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


public class LLStack<E> implements StackADT<E> {

    private Link<E> top;
    private int size;

    public LLStack() {
        this.size = 0;
        this.top = new Link<E>(null,null);
    }


    @Override
    public void clear() {
        this.size = 0;
        this.top = new Link<E>(null,null);
    }

    @Override
    public void push(E item) {
        Link<E> temp = new Link<E>(item,top, null);
        this.top.setNext(temp);
        this.top = temp;
        this.size++;
    }

    @Override
    public E pop() {
        if (this.size == 0) {
            System.out.println("Can not be popped from empty stack");
            return null;
        }
        E element = this.top.getElement();
        this.top = this.top.getPrev();
        this.top.setNext(null);
        this.size--;
        return element;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public E topValue() {
        if(this.size == 0) {
            System.out.println("No top value exists in empty Stack");
            return null;
        }
        return this.top.getElement();
    }

    @Override
    public void setDirection(int direction) {

    }
}
