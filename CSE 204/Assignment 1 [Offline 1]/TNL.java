import java.util.Scanner;

public class TNL {

    private static <E> void printArray(AList<E> RS, AList<E> BS, AList<E> TS, int K) {
        for (Integer i = 0; i < K; i++) {
            int found = RS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
        System.out.println("");
        for (Integer i = 0; i < K; i++) {
            int found = BS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
        System.out.println("");
        for (Integer i = 0; i < K; i++) {
            int found = TS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
    }

    private static <E> void printLL(LList<E> RS, LList<E> BS, LList<E> TS, Integer K) {
        for (Integer i = 0; i < K; i++) {
            int found = RS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
        System.out.println("");
        for (Integer i = 0; i < K; i++) {
            int found = BS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
        System.out.println("");
        for (Integer i = 0; i < K; i++) {
            int found = TS.Search((E)i);
            if(i == 0) {
                if(found != -1) {
                    System.out.print(i);
                }
            }
            else {
                if(found != -1) {
                    System.out.print(","+i);
                }
                else {
                    System.out.print(",");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int K = scn.nextInt();
//        scn.nextLine();
        Integer[] RS, BS, TS;
        RS = new Integer[K];
        for (Integer i = 0; i < K; i++) {
            RS[i] = i;
        }
        int L = scn.nextInt();
//        scn.nextLine();
        BS = new Integer[L];
        for (Integer i = 0; i < L; i++) {
            BS[i] = scn.nextInt();
        }
//        scn.nextLine();
        int M = scn.nextInt();
//        scn.nextLine();
        TS = new Integer[M];
        for (Integer i = 0; i < M; i++) {
            TS[i] = scn.nextInt();
        }
//        scn.nextLine();
        int taskNumber = scn.nextInt();
//        scn.nextLine();

//        AList<Integer> RSList = new AList<>(K, K + 1, RS);
//        AList<Integer> BSList = new AList<>(L, K + 1, BS);
//        AList<Integer> TSList = new AList<>(M, K + 1, TS);

        LList<Integer> RSList = new LList<>(K,K+1,RS);
        LList<Integer> BSList = new LList<>(L,K+1,BS);
        LList<Integer> TSList = new LList<>(M,K+1,TS);

        if (taskNumber == 1) {
//            printArray(RSList, BSList, TSList, K);
            printLL(RSList,BSList,TSList,K);
        }
    }

}
