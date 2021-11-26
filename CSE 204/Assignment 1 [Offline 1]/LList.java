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

public class LList<E> implements ListADT<E> {

    private Link<E> head;
    private Link<E> tail;
    private Link<E> curr;
    private int cnt;

    public LList() {
        head = curr = tail = new Link<E>(null,null);
        cnt = 0;
    }

    public LList(int size) {
        this();
    }

    public LList(int listSize,int maxSize,E[] arr) {
        this();
        for(int i=0;i<listSize;i++) {
            this.append(arr[i]);
        }
        curr = head;
    }

    @Override
    public void clear() {
//        head.setNext(null);
        head = curr = tail = new Link<E>(null,null);
        cnt = 0;
    }

    @Override
    public void insert(E item) {
        Link<E> temp = new Link<E>(item,curr,curr.getNext());
        curr.setNext(temp);
        curr.getNext().setPrev(temp);
        if (curr.equals(tail)) {
            tail.setNext(new Link<E>(item,tail,null));
            tail = tail.getNext();
        }
        cnt++;
    }

    @Override
    public void append(E item) {
        tail.setNext(new Link<E>(item,tail,null));
        tail = tail.getNext();
        cnt++;
    }

    @Override
    public E remove() {
        if (curr.getNext() == null) {
            return null;
        }

        Link<E> temp = curr.getNext();
        if (curr.getNext().equals(tail)) {
            tail.setPrev(null);
            curr.setNext(null);
            tail = curr;
            curr = curr.getPrev();
        }
        else {
            curr.setNext(temp.getNext());
            temp.getNext().setPrev(curr);
            temp.setPrev(null);
            temp.setNext(null);
        }
        cnt--;
        return temp.getElement();
    }

    @Override
    public void moveToStart() {
        curr = head;
    }

    @Override
    public void moveToEnd() {
        curr = tail.getPrev();
    }

    @Override
    public void prev() {
        if (!curr.equals(head)) {
            curr = curr.getPrev();
        }
        else {
//            System.out.println("No previous element found");
        }
    }

    @Override
    public void next() {
        if(curr.equals(tail) || curr.getNext().equals(tail)) {
//            System.out.println("No next element found");
        }
        else {
            curr = curr.getNext();
        }
    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {
        int pos = 0;
        if(cnt == 0) {
            return pos;
        }
        Link<E> temp = head;
        while (!temp.equals(curr)) {
            pos++;
            temp = temp.getNext();
        }
        return pos;
    }

    @Override
    public void moveToPos(int pos) {
        if (pos < 0 && pos >= cnt) {
            System.out.println("Position out of Range");
        } else {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.getNext();
            }
        }
    }

    @Override
    public E getValue() {
        if (curr.getNext() == null) {
            return null;
        }
        return curr.getNext().getElement();
    }

    @Override
    public int Search(E item) {
        int found = -1;
        Link<E> temp = head;
        for (int i = 0; i < cnt; i++) {
            if (temp.getNext().getElement().equals(item)) {
                found = i;
                break;
            }
            temp = temp.getNext();
        }
        return found;
    }
}
