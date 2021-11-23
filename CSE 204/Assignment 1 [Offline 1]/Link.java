public class Link<E> {
    private E element;
    private Link<E> next;
    private Link<E> prev;


    public Link(E element, Link<E> prevLink, Link<E> nextLink) {
        this.element = element;
        this.next = nextLink;
        this.prev = prevLink;
    }

    public Link(Link<E> prevLink, Link<E> nextLink) {
        next = nextLink;
        prev = prevLink;
    }

    public Link<E> getNext() {
        return next;
    }

    public void setNext(Link<E> nextLink) {
        next = nextLink;
    }

    public Link<E> getPrev() {
        return prev;
    }

    public void setPrev(Link<E> prevLink) {
        prev = prevLink;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}

