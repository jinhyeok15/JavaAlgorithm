package search;

public class Q3 {
    public static int searchIdx(int[] a, int n, int key, int[] idx) {
        int nm=0;
        for (int i=0; i<n; i++) {
            if(a[i]==key) {
                idx[nm] = i;
                System.out.println(i);
                if(i!=n-1){
                    nm++;
                }
            }
        }
        return nm+1;
    }
}
