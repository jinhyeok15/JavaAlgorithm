package search;

public class Q4 {
    public static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n-1;

        column(n);
        do {
            int pc = (pl+pr) / 2;
            if(a[pc] == key){
                scope(a,pl,pr);
                System.out.println("\n");
                return pc;
            }
            else if (a[pc] < key) {
                scope(a,pl,pr);
                indent(n);
                pl = pc + 1;
            }
            else
                scope(a,pl,pr);
                indent(n);
                pr = pc-1;
        } while (pl <= pr);

        return -1;
    }

    private static void column(int n){
        StringBuilder first_line = new StringBuilder("   |");
        StringBuilder second_line = new StringBuilder("---+");
        int i = 0;
        while(i<n){
            first_line.append(String.format("  %d  ", i));
            second_line.append("-----");
            i++;
        }
        second_line.append("--");
        System.out.println(first_line);
        System.out.println(second_line);
    }

    private static void scope(int[] a, int pl, int pr) {
        int pc = (pl+pr)/2;
        StringBuilder checker = new StringBuilder("   |");
        StringBuilder idx_indicator = new StringBuilder(
                String.format("  %d|", pc));
        for (int i=0; i<a.length; i++) {
            if (i==pl)
                checker.append(" <-  ");
            else if (i==pr)
                checker.append(" ->  ");
            else if (i==pc)
                checker.append("  +  ");
            else
                checker.append("     ");
            idx_indicator.append(String.format("  %d  ", a[i]));
        }
        System.out.println(checker);
        System.out.println(idx_indicator);
    }

    private static void indent(int n) {
        StringBuilder str = new StringBuilder("   |");
        for(int i=0;i<n;i++) {
            str.append("     ");
        }
        System.out.println(str);
    }

    public static void main(String[] args) throws Exception {
        int[] search = {1,2,3,5,6,8,9};
        int n = search.length;
        int key = 2;
        System.out.printf("%d는 x[%d]에 있습니다.%n", key, binSearch(search,n,key));
    }
}
