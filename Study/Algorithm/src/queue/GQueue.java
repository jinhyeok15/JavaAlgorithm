package queue;

import java.util.List;

public class GQueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E [] que;

    @SuppressWarnings("unckecked")
    public GQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E enque(E x) throws RuntimeException{
        if (num >= max)
            throw new RuntimeException();
        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
        return x;
    }

    public E deque() throws RuntimeException{
        if (num<=0)
            throw new RuntimeException();
        E x = que[front++];
        num--;
        if (front == max)
            front = 0;
        return x;
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i<num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }
}
