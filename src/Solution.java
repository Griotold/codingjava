import java.util.*;

class Solution {

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2]; // 2, 2
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int dir = 0;
        int len = board.length;
        answer[0] = 0;
        answer[1] = 0;
        while(k-- > 0) {
            int ny = answer[0] + dy[dir];
            int nx = answer[1] + dx[dir];
            // ny, nx가 board를 벗어나는 경우 || ny, nx가 장애물인 경우
            if(ny >= len || ny < 0 || nx >= len || nx < 0 || board[ny][nx] == 1) {
                dir++;
            }
            // ny, nx가 갈 수 있는 경우
            else if(board[ny][nx] == 0) {
                answer[0] = ny;
                answer[1] = nx;
            }
            if(dir >= 4) dir %= 4;
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
