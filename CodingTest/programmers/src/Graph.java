import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static void DFS(int[] numbers, int idx, boolean[] visit) {
        visit[idx] = true;
        for (boolean v:visit){
            System.out.print(v);
        }
        for(int i : numbers) {
            if(!visit[i]) {
                DFS(numbers, i, visit);
            }
        }
        System.out.println();
    }

    void BFS(int[] numbers, int start, boolean[] visit) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll();

            for (int i : numbers) {
                if (!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        boolean[] visit = new boolean[5];

        DFS(numbers, 0, visit);
    }
}
