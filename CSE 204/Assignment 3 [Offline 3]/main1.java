import java.util.Scanner;

public class main1 {

    private static <E> void printArrQueue(ArrQueue<E> Arr) {
        ArrQueue tempQueue = new ArrQueue(Arr.length() + 1);
        System.out.print("<");
        int len = Arr.length();
        for (int i = 0; i < len; i++) {
            E item = Arr.dequeue();
            if (i == 0) {
                System.out.print(item);
            } else {
                System.out.print(" " + item);
            }
            tempQueue.enqueue(item);
        }
        System.out.println(">");
        while (tempQueue.length() > 0) {
            Arr.enqueue((E) tempQueue.dequeue());
        }
    }

    private static <E> void printLLQueue(LLQueue<E> Arr) {
        LLQueue tempQueue = new LLQueue();
        System.out.print("<");
        int len = Arr.length();
        for (int i = 0; i < len; i++) {
            E item = Arr.dequeue();
            if (i == 0) {
                System.out.print(item);
            } else {
                System.out.print(" " + item);
            }
            tempQueue.enqueue(item);
        }
        System.out.println(">");
        while (tempQueue.length() > 0) {
            Arr.enqueue((E) tempQueue.dequeue());
        }
    }

    private static void checkArrQueueImp() {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        ArrQueue arr = new ArrQueue(size + 1);
//        ArrQueue arr = new ArrQueue();
        for (int i = 0; i < size; i++) {
            Integer item = scn.nextInt();
            arr.enqueue(item);
        }
        printArrQueue(arr);
        int q, p;
        while (true) {
            q = scn.nextInt();
            p = scn.nextInt();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                arr.clear();
                printArrQueue(arr);
                System.out.println(-1);
            } else if (q == 2) {
                arr.enqueue(p);
                printArrQueue(arr);
                System.out.println(-1);
            } else if (q == 3) {
                Integer temp = (Integer) arr.dequeue();
                printArrQueue(arr);
                System.out.println(temp);
            } else if (q == 4) {
                printArrQueue(arr);
                System.out.println(arr.length());
            } else if (q == 5) {
                printArrQueue(arr);
                System.out.println(arr.frontValue());
            } else if (q == 6) {
                printArrQueue(arr);
                System.out.println(arr.rearValue());
            } else if (q == 7) {
                Integer temp = (Integer) arr.leaveQueue();
                printArrQueue(arr);
                System.out.println(temp);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static void checkLLQueueImp() {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        LLQueue arr = new LLQueue();
        for (int i = 0; i < size; i++) {
            Integer item = scn.nextInt();
            arr.enqueue(item);
        }
        printLLQueue(arr);
        int q, p;
        while (true) {
            q = scn.nextInt();
            p = scn.nextInt();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                arr.clear();
                printLLQueue(arr);
                System.out.println(-1);
            } else if (q == 2) {
                arr.enqueue(p);
                printLLQueue(arr);
                System.out.println(-1);
            } else if (q == 3) {
                Integer temp = (Integer) arr.dequeue();
                printLLQueue(arr);
                System.out.println(temp);
            } else if (q == 4) {
                printLLQueue(arr);
                System.out.println(arr.length());
            } else if (q == 5) {
                printLLQueue(arr);
                System.out.println(arr.frontValue());
            } else if (q == 6) {
                printLLQueue(arr);
                System.out.println(arr.rearValue());
            } else if (q == 7) {
                Integer temp = (Integer) arr.leaveQueue();
                printLLQueue(arr);
                System.out.println(temp);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        checkArrQueueImp();
//        checkLLQueueImp();
    }
}
