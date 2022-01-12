public class ExpressN {
    public int solution(int N, int number) {
        int answer = 0;
        /* 설계
        연산을 해줄 수 있는 Calc 객체의 메소드가 필요하다.
        Calc 객체의 메소드들은 각각 두개의 int 값이 필요하다. 따라서, Calc 객체는 생성자에 int a, int b 이라는 인자를 부여한다.
        Calc 객체 메소드:
            arrange # 나열 ex) f(a, b) = 10*a+b
            plus
            minus
            mult
            div

        연산 결과를 인자로 받으면서 타깃 number 와 맞을때까지 횟수를 return 해주는 메소드를 solution 에서 구현할 것.
        */
        return answer;
    }



    class TestCase {
        /* 조건
        1<=N<=9
        1<=number<=32000
        div는 나머지 무시
        count>8 => -1
        */
        public final int testN;
        public final int testNumber;
        public final int answer;

        public TestCase(int testN, int testNumber, int answer) {
            this.testN = testN;
            this.testNumber = testNumber;
            this.answer = answer;
        }

        public void printCase() {

        }
    }
}
