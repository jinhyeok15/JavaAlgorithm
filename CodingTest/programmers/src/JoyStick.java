public class JoyStick {
    public int solution(String name) {
        char[] nameChar = name.toCharArray();
        int len = nameChar.length;
        char[] aChar = new char[len];
        for (int i=0; i<len; i++) {
            aChar[i] = 'A';
        }
        Move move = new Move(aChar);

        int moveCount;
        while(true) {
            int up = receiveCount("UP", nameChar, move.getArr(), move.point());
            int down = receiveCount("DOWN", nameChar, move.getArr(), move.point());
            moveCount = up < -down ? up : down;
            for (int i=0; i<Math.abs(moveCount); i++) {
                if (moveCount>0) move.vertical(1);
                else move.vertical(-1);
            }

            int right = receiveCount("RIGHT", nameChar, move.getArr(), move.point());
            int left = receiveCount("LEFT", nameChar, move.getArr(), move.point());
            moveCount = -left < right ? left: right;
            if (moveCount==0) {
                break;
            }
            for (int i=0; i<Math.abs(moveCount); i++) {
                if (moveCount>0) move.horizontal(1);
                else move.horizontal(-1);
            }
        }

        return move.count;
    }

    public enum Operator{
        UP, DOWN, LEFT, RIGHT;
    }

    public int receiveCount(String typeName, char[] nameArr, char[] currentArr, int idx) {
        int len = nameArr.length;
        Operator op = Operator.valueOf(typeName);
        char[] newArr = new char[len];
        for (int i=0; i<len; i++) {
            newArr[i] = currentArr[i];
        }
        Move move = new Move(newArr);
        move.setPoint(idx);
        int i = 0;
        switch (op) {
            case UP:
                while(nameArr[move.point()]!=move.getChar()) {
                    move.vertical(1);
                }
                return move.count;
            case DOWN:
                while(nameArr[move.point()]!=move.getChar()) {
                    move.vertical(-1);
                }
                return -move.count;
            case LEFT:
                while(nameArr[move.point()]==move.getChar() && i<len) {
                    move.horizontal(-1);
                    i++;
                }
                if (i==len) return 0;
                return -move.count;
            case RIGHT:
                while(nameArr[move.point()]==move.getChar() && i<len) {
                    move.horizontal(1);
                    i++;
                }
                if (i==len) return 0;
                return move.count;
        }
        return 0;
    }


    class Move {
        private final char[] charArr;
        private int idx;
        public int count;
        private final int len;

        public Move(char[] charArr) {
            this.charArr = charArr;
            this.len = charArr.length;
            this.idx = 0;
            this.count = 0;
        }

        public char getChar() {
            return charArr[idx];
        }
        public char[] getArr() {
            return charArr;
        }
        public int point() {
            return idx;
        }
        public void setPoint(int index) {
            idx = index;
        }

        public void vertical(int step) {
            if (charArr[idx]=='A'&&step==-1) {
                charArr[idx] = 'Z';
            } else if (charArr[idx]=='Z'&&step==1) {
                charArr[idx] = 'A';
            } else {
                charArr[idx] += step;
            }
            count++;
        }

        public void horizontal(int step) {
            if (idx==0 && step==-1) {
                idx = len-1;
            } else if (idx==len-1 && step==1) {
                idx = 0;
            } else {
                idx += step;
            }
            count++;
        }
    }
}
