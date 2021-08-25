package recursive;

import java.util.Scanner;

public class Q1 {
    public static int factorial(int n){
        if(n==0)
            return 1;
        int result=1;
        for(int i=1; i<=n; i++) {
            result = result*i;
        }
        return result;
    }

    // 재귀 메서드 사용하지 않고 factorial 메서드 작성하기
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("팩토리얼 구하기");

        System.out.print("정수를 입력하세요 :"); int n = stdIn.nextInt();

        System.out.println("팩토리얼 값은 "+factorial(n)+"입니다.");
    }
}
