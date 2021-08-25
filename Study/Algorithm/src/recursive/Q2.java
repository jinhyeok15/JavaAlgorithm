package recursive;

public class Q2 {
    public static int gcd(int x, int y) {
        if (x < y) {
            int i = x;
            x = y;
            y = i;
        }

        while (true) {
            int min = x%y;
            x = y;
            y = min;
            if (y == 0)
                return x;
        }
    }

    public static void main(String[] args) {
        int x = 10; int y = 4;
        System.out.println(gcd(x,y));
    }
}
