package recursive;

import stack.IntStack;

import java.util.Scanner;

public class Recur {

    static void recur(int n) {
        if (n > 0) {
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }

    static void recur3(int n) {
        if(n>0) {
            recur3(n-1);
            recur3(n-2);
            System.out.println(n);
        }
    }

    static void recur5(int n) {
        IntStack s = new IntStack(n);

        while(true) {
            if (n > 0){
                s.push(n);
                n = n-1;
                continue;
            }
            while (!s.isEmpty()){
                if (n-1>0){
                    
                }
                n = s.pop();
                System.out.println(n);
            }
            break;
        }
    }

    static int getUnsigned(int n) {
        return Math.max(n, 0);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요.: ");
        int x = stdIn.nextInt();

//        recur(x);
        recur5(x);
    }
}
