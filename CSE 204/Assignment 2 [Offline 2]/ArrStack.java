public class ArrStack<E> implements StackADT<E> {

    private static final int defaultSize = 5;  //default maxsize

    private int direction = 1;      //default 1
    private int chunkSize;
    private int top;
    private int maxSize;
    private E[] listArray;

//    public ArrStack(int size, int direction, E[] Arr) {
//        //this(size, direction);
//        for (E item : Arr) {
//            this.push(item);
//        }
////        this.maxSize = this.chunkSize = size;
////        this.direction = direction;
////        this.listArray = Arr;
////        if(direction == 1) {
////            this.top = this.listArray.length;
////        }
////        else {
////            this.top = -1;
////        }
//    }

    public ArrStack(int direction,E[] arr) {
        this.listArray = arr;
        this.direction = direction;
        this.maxSize = this.chunkSize = arr.length;
        if(direction == 1) {
            this.top = 0;
        }
        else {
            this.top = arr.length-1;
        }
    }

    public ArrStack(int size) {
        this.maxSize = this.chunkSize = size;
        this.direction = 1;
        this.listArray = (E[]) new Object[this.maxSize];
        this.top = 0;
    }

    //helper function
    private void increaseStack() {
        this.maxSize += this.chunkSize;
        E[] temp = (E[]) new Object[this.maxSize];
        if (this.direction == 1) {
            for (int i = 0; i < this.listArray.length; i++) {
                temp[i] = this.listArray[i];
            }
            this.listArray = temp;
        } else {
            for (int i = this.listArray.length - 1; i >= 0; i--) {
                temp[i+this.chunkSize] = this.listArray[i];
            }
            this.listArray = temp;
            this.top+=this.chunkSize;
        }
    }

    @Override
    public void clear() {
        //this.listArray = (E[]) new Object[this.length()];
        if (this.direction == 1) {
            this.top = 0;
        } else {
            this.top = this.listArray.length - 1;
        }
    }

    @Override
    public void push(E item) {
        if (this.length() == this.maxSize) {
            increaseStack();
        }
        if (this.direction == 1) {
            this.listArray[this.top] = item;
            this.top++;
        } else {
            this.listArray[this.top] = item;
            this.top--;
        }

    }

    @Override
    public E pop() {
        if (this.length() == 0) {
            System.out.println("Can not pop from empty Stack");
            return null;
        } else {
            if (this.direction == 1) {
                return this.listArray[--this.top];
            } else {
                return this.listArray[++this.top];
            }
        }
    }

    @Override
    public int length() {
        if (this.direction == 1) {
            return this.top;
        } else {
            return this.listArray.length - this.top - 1;
        }
    }

    @Override
    public E topValue() {
        if (this.length() == 0) {
            System.out.println("No top value in empty Stack");
            return null;
        } else {
            if (this.direction == 1) {
                return this.listArray[this.top - 1];
            } else {
                return this.listArray[this.top + 1];
            }
        }
    }

    @Override
    public void setDirection(int direction) {
        if (this.length() == 0) {
            //this.clear();
            if(direction == 1) {
                this.direction = direction;
                this.top = 0;
            }
            else if(direction == -1) {
                this.direction = direction;
                this.top = this.listArray.length - 1;
            }
            else {
                System.out.println("Invalid direction");
            }
        } else {
            System.out.println("Can not set direction in this Stack");
        }
    }
}