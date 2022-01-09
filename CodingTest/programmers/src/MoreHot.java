import java.util.*;

// 더맵게 문제 설명.
// 배열 -> scoville = 맵기 지수 int
// 매운음식을 만들기 위해서는 적어도 K이상의 맵기 지수
// {1, 3, 5, 7, 9} k=7
// 조건을 만족하는게 7, 9
// 이 배열에서 가장 작은 두 수 꺼내와 1, 3 1+2*3 = 7 조건 만족
// {7, 5, 7, 9} 이 배열 내부 원소들이 전부 7이상이 되도록 이 조건 반복
// 반복 횟수를 return

class MoreHot {
    public int solution(int[] scoville, int K) throws Exception {
        int answer = 0;
        ScovStorage storage = new ScovStorage(scoville);

        return answer;
    }

//    public boolean scovCondition(ScovStorage storage) {
//        if (storage.size()==1) {
//            if ()
//        }
//    }

    public static void main(String[] args) throws Exception {
        int[] scov = {1, 2, 3, 10, 9, 12};
        int K = 7;
        MoreHot instance = new MoreHot();
        instance.solution(scov, K);
    }

}

class ScovStorage {
    private final int[] scoville;
    private int cursor;
    private final int maxIdx;

    public class StorageSizeError extends Exception {
        public StorageSizeError() { }
    }

    public ScovStorage(int[] scoville) throws StorageSizeError {
        Arrays.sort(scoville);
        this.scoville = scoville;
        this.maxIdx = scoville.length-1;
        if (maxIdx<2) {
            throw new StorageSizeError();
        }
        this.cursor = 0;
    }

    // scov 요소 가져오기
    public int get(int idx) {
        int i = idx+cursor;
        return scoville[i];
    }

    public int remove() {
        return (cursor < maxIdx) ? scoville[cursor++] : scoville[cursor];
    }

    // 무조건 remove가 먼저 실행된 후 사용해야함!!
    public void input(int num) {
        int i = 0;
        if (scoville[maxIdx]<num) return;
        while (true) {
            if (this.get(i)<num) {
                if (i==0) {
                    cursor--;
                    scoville[cursor] = this.get(i);
                } else {
                    scoville[cursor+i] = this.get(i);
                }
            } else {
                if (i==0) {
                    cursor--;
                    scoville[cursor] = num;
                } else {
                    scoville[cursor+i] = num;
                }
                return;
            }
            i++;
        }
    }

    public int size() {
        return maxIdx-cursor+1;
    }
}
