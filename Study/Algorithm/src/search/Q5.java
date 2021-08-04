package search;

public class Q5 {
    public static int binSearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n-1;
        do {
            int pc = (pl+pr) / 2;
            if(a[pc] == key){
//                while(a[pc]==a[pc-1]){
//                    pc--;
//                    if(pc==0)  // 인덱스 에러 방지;;
//                        break;
//                }
//                return pc;
                for(;pl<pc+1;pl++){
                    if(a[pl]==key)
                        return pl;
                }
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
        int[] a = {3,5,6,6,6,6,6,6,7,7,7};
        int n = a.length;
        int key = 6;
//        int search = binSearchX(a,n,key);
        if (binSearchX(a,n,key)!=-1){
            System.out.printf("a[%d]", binSearchX(a,n,key));
        }
        else
            System.out.println("결과 없음");
    }
}
