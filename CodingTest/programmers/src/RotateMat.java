public class RotateMat {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answers = new int[queries.length];
        int[][] matriex = createMat(rows, columns);
        int[][] newMat = createMat(rows, columns);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0;
        for (int[] q : queries) {
            int ix1, iy1, ix2, iy2;
            ix1 = q[0]-1; iy1 = q[1]-1; ix2 = q[2]-1; iy2 = q[3]-1;
            int[] idxScope = {ix1, iy1, ix2, iy2};
            int[] xyMap = {ix1, iy1};
            int answer = 0;
            for (int[] dir : directions) {
                while (inScope(xyMap[0]+dir[0], xyMap[1]+dir[1], idxScope)) {
                    int value = matriex[xyMap[0]][xyMap[1]];
                    if (answer==0 || answer>value)
                        answer = value;
                    xyMap[0]=xyMap[0]+dir[0]; xyMap[1]=xyMap[1]+dir[1];
                    newMat[xyMap[0]][xyMap[1]] = value;
                }
            }
            matriex = changeMat(matriex, newMat);
            answers[i] = answer;
            i++;
        }
        return answers;
    }

    private static int[][] createMat(int rows, int columns) {
        int[][] arrOut = new int[rows][columns];
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                int num = columns*r+c+1;
                arrOut[r][c] = num;
            }
        }
        return arrOut;
    }

    private static boolean inScope(int ix, int iy, int[] idxScope) {
        if (ix>idxScope[2] || ix<idxScope[0])
            return false;
        if (iy>idxScope[3] || iy<idxScope[1])
            return false;
        return true;
    }

    private static int[][] changeMat(int[][] oldMat, int[][] newMat) {
        for (int row=0; row<oldMat.length; row++) {
            for (int col=0; col<oldMat[row].length; col++) {
                oldMat[row][col] = newMat[row][col];
            }
        }
        return oldMat;
    }
}
