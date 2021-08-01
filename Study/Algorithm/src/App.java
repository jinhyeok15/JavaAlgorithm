import search.Q3;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {1,9,2,9,4,6,7,9};
        int n = 8;
        int key = 9;
        int[] idx = new int[3];
        int search = Q3.searchIdx(a, n, key, idx);
        System.out.println(search);
    }
}
