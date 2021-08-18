package queue;

public class IntDeckQue {
    private int max;
    private int num;
    private int enqueCursor;
    private int dequeCursor;
    private int enqueIdx;
    private int dequeIdx;
    private int[] que;

    public IntDeckQue(int capacity) {
        num = enqueCursor = dequeCursor = dequeIdx = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enque(int x) throws RuntimeException {
        if (num >= max)
            throw new RuntimeException();

        if (enqueCursor==0){ // start
            enqueIdx = 0;
            que[enqueIdx] = x;
            enqueCursor--;
        } else if (enqueCursor<0){
            int idx = max+enqueCursor;
            que[idx] = x;
            enqueCursor = enqueIdx+1;
            enqueIdx = idx;
        } else {
            int idx = enqueCursor;
            que[idx] = x;
            enqueCursor = enqueIdx-max-1;
            enqueIdx = idx;
        }

        num++;
        return x;
    }

    public int deque() throws RuntimeException {
        if (num<=0)
            throw new RuntimeException();
        num--;
        if (dequeCursor==0) {
            dequeIdx = 0;
            int x = que[dequeIdx];
            dequeCursor--;
            return x;
        }
        if(dequeCursor<0) {
            int idx = max+dequeCursor;
            int x = que[idx];
            dequeCursor = dequeIdx+1;
            dequeIdx = idx;
            return x;
        }
        int idx = dequeCursor;
        int x = que[idx];
        dequeCursor = dequeIdx-max-1;
        dequeIdx = idx;
        return x;
    }

    public int indexOf(int x) {
        int front_;
        int _front;
        int rear_;
        int _rear;
        if (dequeCursor>=0) {
            front_ = dequeCursor;
            _front = dequeIdx-1;
        }
        else {
            front_ = dequeIdx-1;
            _front = dequeCursor+max;
        }
        if (enqueCursor>=0) {
            _rear = enqueCursor-1;
            rear_ = enqueIdx;
        }
        else {
            _rear = enqueIdx;
            rear_ = enqueCursor+max+1;
        }
        System.out.println(front_+":"+_rear+", "+rear_+":"+_front);
        for (int idx=front_;idx<=_rear; idx++) {
            if (que[idx] == x)
                return idx;
        }

        for (int idx=rear_; idx<=_front; idx++) {
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = enqueCursor = dequeCursor = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {  // 덤프 구현 질문!!
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            int front_;
            int _front;
            int rear_;
            int _rear;
            if (dequeCursor>=0) {
                front_ = dequeCursor;
                if (dequeIdx==0)  // _front는 커서 방향이 음수로 세팅 되어야 함.
                    _front = max-1;
                else
                    _front = dequeIdx-1;
            } else {
                if(dequeIdx==0)  // 만일 deque를 실행시키지 않았다면, dequeIdx는 0이 되고 해당 인덱스에 값이 남아있음.
                    front_ = 0;
                else
                    front_ = dequeIdx+1;
                _front = dequeCursor+max;
            }
            if (enqueCursor>=0) {
                _rear = enqueCursor-1;
                if (enqueIdx==0)  // rear_는 커서 방향이 음수로 세팅 되어야 함.
                    rear_ = max-1;
                else
                    rear_ = enqueIdx;
            } else {
                _rear = enqueIdx;
                rear_ = enqueCursor+max+1;
            }

            for (int idx=front_;idx<=_rear; idx++) {
                System.out.print(que[idx] + " ");
            }

            for (int idx=rear_; idx<=_front; idx++) {
                System.out.print(que[idx] + " ");
            }
            System.out.println();
        }
    }
}
