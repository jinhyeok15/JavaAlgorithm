package recursive;

public class Hanoi {
    static void move(int no, int x, int y) {
        if(no>1)
            move(no-1, x, 6-x-y);

        System.out.println("원반[" +no+"]을 "+x+"기둥에서 "+"기둥으로 옮김");

        if(no>1)
            move(no-1, 6-x-y, y);
    }

    public static void main(String[] args) {
        int no = 4;
        int x = 1;
        int y = 3;
        move(4,1,3);
    }
}
