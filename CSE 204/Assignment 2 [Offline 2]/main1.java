import java.util.Scanner;

public class main1 {
    private static <E> void printArrStack(ArrStack<E> Arr) {
        int len = Arr.length();
        E[] arr = (E[]) new Object[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Arr.pop();
        }
        System.out.print("<");
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(" " + arr[i]);
            }
            Arr.push(arr[i]);
        }
        System.out.println(">");
    }

    private static <E> void printLLStack(LLStack<E> Arr) {
        int len = Arr.length();
        E[] arr = (E[]) new Object[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Arr.pop();
        }
        System.out.print("<");
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(" " + arr[i]);
            }
            Arr.push(arr[i]);
        }
        System.out.println(">");
    }

    private static void checkArrStackImp() {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        ArrStack Arr = new ArrStack(size);
//        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            Arr.push(scn.nextInt());
        }

        printArrStack(Arr);

        while (true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
//            scn.nextLine();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                Arr.clear();
                printArrStack(Arr);
                System.out.println(-1);
            } else if (q == 2) {
                Arr.push(p);
                printArrStack(Arr);
                System.out.println(-1);
            } else if (q == 3) {
                Integer temp = (Integer) Arr.pop();
                printArrStack(Arr);
                System.out.println(temp);
            } else if (q == 4) {
                Integer temp = (Integer) Arr.length();
                printArrStack(Arr);
                System.out.println(temp);
            } else if (q == 5) {
                Integer temp = (Integer) Arr.topValue();
                printArrStack(Arr);
                System.out.println(temp);
            } else if (q == 6) {
                Arr.setDirection(p);
                printArrStack(Arr);
                System.out.println(-1);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private static void checkLLStackImp() {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        LLStack Arr = new LLStack();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            Arr.push(scn.nextInt());
        }

        printLLStack(Arr);

        while (true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
//            scn.nextLine();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                Arr.clear();
                printLLStack(Arr);
                System.out.println(-1);
            } else if (q == 2) {
                Arr.push(p);
                printLLStack(Arr);
                System.out.println(-1);
            } else if (q == 3) {
                Integer temp = (Integer) Arr.pop();
                printLLStack(Arr);
                System.out.println(temp);
            } else if (q == 4) {
                Integer temp = (Integer) Arr.length();
                printLLStack(Arr);
                System.out.println(temp);
            } else if (q == 5) {
                Integer temp = (Integer) Arr.topValue();
                printLLStack(Arr);
                System.out.println(temp);
            } else if (q == 6) {
                Arr.setDirection(p);
                printLLStack(Arr);
                System.out.println(-1);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {
        checkArrStackImp();
//        checkLLStackImp();
    }
}
