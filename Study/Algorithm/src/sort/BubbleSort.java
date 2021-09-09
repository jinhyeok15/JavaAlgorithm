package sort;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        int compare = 0;
        int exchange = 0;
        for (int i = 0; i < n-1; i++) {
            System.out.println("패스"+(i+1)+":");
            // pass
            for (int j = n - 1; j > i; j--) {
                System.out.print(" ");
                for (int k=0; k<n; k++) {
                    if(k==j-1){
                        if(a[j-1] > a[j])
                            System.out.print(a[k]+" + ");
                        else
                            System.out.print(a[k]+" - ");
                    }
                    else {
                        System.out.print(a[k]+"   ");
                    }
                }
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchange++;
                }
                compare++;
                System.out.println();
            }
            System.out.print(" ");
            for (int j=0; j<n; j++) {
                System.out.print(a[j]+"   ");
            }
            System.out.println();
        }
        System.out.println("비교를 "+compare+"회 "+"했습니다.");
        System.out.println("교환을 "+exchange+"회 "+"했습니다.");
    }

    static void bubbleSort2(int[] a, int n) {
        for (int i = n-1; i > 0; i--)
            for (int j = 0; j<i; j++)
                if (a[j+1] < a[j])
                    swap(a, j+1, j);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++) {
            System.out.print("x["+i+"]: ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}
