package search;

public class Q5 {
    public static int binSearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n-1;

        do {
            int pc = (pl+pr) / 2;
            if(a[pc] == key){
                while(a[pc]==a[pc-1]){
                    pc--;
                    if(pc==0)  // 인덱스 에러 방지;;
                        break;
                }
                return pc;
            }
            else if (a[pc] < key) {
                pl = pc + 1;
            }
            else
            pr = pc-1;
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) throws Exception{
        int[] a = {1,3,5,7,7,7,7,8,8,9,9};
        int n = a.length;
        int key = 7;
        int search = binSearchX(a,n,key);
        if (search!=-1){
            System.out.printf("a[%d]", search);
        }
        else
            System.out.println("결과 없음");
    }
}
