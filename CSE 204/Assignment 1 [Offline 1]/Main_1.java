import java.util.Scanner;

public class Main_1 {

    private static <E> void printArray(AList<E> Arr) {
        int tempPos = Arr.currPos();
        Arr.moveToStart();
        System.out.print("<");
        for (int i = 0; i < Arr.length(); i++) {
            if (i == tempPos) {
                if (i == Arr.length() - 1) {
                    System.out.print("| " + Arr.getValue());
                } else {
                    System.out.print("| " + Arr.getValue() + " ");
                }
            } else {
                if (i == Arr.length() - 1) {
                    System.out.print(Arr.getValue());
                } else {
                    System.out.print(Arr.getValue() + " ");
                }
            }
            if(i != Arr.length()-1) {
                Arr.next();
            }
        }
        if(tempPos != Arr.length()) {
            Arr.moveToPos(tempPos);
        }
        System.out.println(">");
    }

    private static <E> void printLL(LList<E> Arr) {
        int tempPos = Arr.currPos();
        Arr.moveToStart();
        System.out.print("<");
        for (int i = 0; i < Arr.length(); i++) {
            if (i == tempPos) {
                if (i == Arr.length() - 1) {
                    System.out.print("| " + Arr.getValue());
                } else {
                    System.out.print("| " + Arr.getValue() + " ");
                }
            } else {
                if (i == Arr.length() - 1) {
                    System.out.print(Arr.getValue());
                } else {
                    System.out.print(Arr.getValue() + " ");
                }
            }
            if(i != Arr.length()-1) {
                Arr.next();
            }
        }
        if(tempPos != Arr.length()) {
            Arr.moveToPos(tempPos);
        }
        System.out.println(">");
    }

    private static void checkArrImp() {
        int K, X;
        Integer[] arr;
        Scanner scn = new Scanner(System.in);
        K = scn.nextInt();
        X = scn.nextInt();
        scn.nextLine();
        arr = new Integer[K];
        for (int i = 0; i < K; i++) {
            arr[i] = scn.nextInt();
        }
        scn.nextLine();

        AList Arr = new AList(K, X, arr);

        printArray(Arr);

        while (true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
            scn.nextLine();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                Arr.clear();
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 2) {
                Arr.insert(p);
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 3) {
                Arr.append(p);
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 4) {
                Integer temp = (Integer) Arr.remove();
                printArray(Arr);
                System.out.println(temp);
            } else if (q == 5) {
                Arr.moveToStart();
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 6) {
                Arr.moveToEnd();
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 7) {
                Arr.prev();
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 8) {
                Arr.next();
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 9) {
                printArray(Arr);
                System.out.println(Arr.length());
            } else if (q == 10) {
                printArray(Arr);
                System.out.println(Arr.currPos());
            } else if (q == 11) {
                Arr.moveToPos(p);
                printArray(Arr);
                System.out.println("-1");
            } else if (q == 12) {
                printArray(Arr);
                System.out.println(Arr.getValue());
            } else if (q == 13) {
                printArray(Arr);
                System.out.println(Arr.Search(p));
            } else {
                System.out.println("Invalid Input");
            }

        }
    }

    private static void checkLLImp() {
        int K, X;
        Integer[] arr;
        Scanner scn = new Scanner(System.in);
        K = scn.nextInt();
        X = scn.nextInt();
        scn.nextLine();
        arr = new Integer[K];
        for (int i = 0; i < K; i++) {
            arr[i] = scn.nextInt();
        }
        scn.nextLine();

        LList Arr = new LList(K, X, arr);

        printLL(Arr);

        while (true) {
            int q = scn.nextInt();
            int p = scn.nextInt();
            scn.nextLine();
            if (q == 0) {
                scn.close();
                break;
            } else if (q == 1) {
                Arr.clear();
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 2) {
                Arr.insert(p);
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 3) {
                Arr.append(p);
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 4) {
                Integer temp = (Integer) Arr.remove();
                printLL(Arr);
                System.out.println(temp);
            } else if (q == 5) {
                Arr.moveToStart();
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 6) {
                Arr.moveToEnd();
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 7) {
                Arr.prev();
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 8) {
                Arr.next();
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 9) {
                printLL(Arr);
                System.out.println(Arr.length());
            } else if (q == 10) {
                printLL(Arr);
                System.out.println(Arr.currPos());
            } else if (q == 11) {
                Arr.moveToPos(p);
                printLL(Arr);
                System.out.println("-1");
            } else if (q == 12) {
                printLL(Arr);
                System.out.println(Arr.getValue());
            } else if (q == 13) {
                printLL(Arr);
                System.out.println(Arr.Search(p));
            } else {
                System.out.println("Invalid Input");
            }

        }
    }

    public static void main(String[] args) {
        //checkArrImp();
        checkLLImp();
    }
}
