public class MenuRenewal {
    private static boolean[] visited;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for (String order : orders) {
            int ord_size = orders.length;
            int[][] idxBox = new int[ord_size][ord_size];
            for (int i=0; i<ord_size; i++) {
                int[] rangeArr = new int[ord_size];
                for (int j=0; j<ord_size; j++) {
                    rangeArr[j] = j;
                }
                idxBox[i] = rangeArr;
            }
            for (int i=0; i< course.length; i++) {
                visited = new boolean[course[i]];
            }
        }
        return answer;
    }
    private static String[] dfs(String order, int courseNum, int[][] idxBox, int[] path) {
        int idx = idxBox[path[0]][path[1]];
        visited[idx] = true;
        return new String[]{};
    }
    private static int[] nextPath(int[] path, int maxNum) {
        int m = path[0];
        int n = path[1];
        if (n < maxNum-1) {
            path[1]++;
            return path;
        }

        return path;
    }
}
