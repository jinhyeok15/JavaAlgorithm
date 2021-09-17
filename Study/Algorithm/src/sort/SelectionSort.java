package sort;

public class SelectionSort extends Sort {
    @Override
    public void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void selectionSort(int[] a, int n) {
        SelectionSort sort = new SelectionSort();
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[min])
                    min = j;
        sort.swap(a, i, min);
        }
    }
}
