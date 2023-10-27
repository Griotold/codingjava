package it_big_company_problem.ch1_simulation;

import java.util.Arrays;
/**
 * 해낼 수 있다고 생각하면 해낼 수 있게 된다.
 * */
public class 청소_2 {
    /**
     * 내 풀이
     * */
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

    /**
     * 강사님 풀이 - 내 풀이랑 동일, 코딩 스타일 차이
     */
    public int[] solByTeacher(int[][] board, int k) {
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;
        while (count < k) {
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        청소_2 T = new 청소_2();
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
