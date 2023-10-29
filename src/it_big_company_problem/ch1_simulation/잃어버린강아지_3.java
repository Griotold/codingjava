package it_big_company_problem.ch1_simulation;
/**
 * 청소_2 문제랑 비슷
 * 두 개체가 이동한다는 것만 다름
 * */
public class 잃어버린강아지_3 {
    /**
     * 내 풀이
     * */
    public int solution(int[][] board){
        int answer = 0, count = 0, max = 10000;
        int y = 0, x = 0, dogY = 0, dogX = 0;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        // 1. 초기화 = 현수의 좌표, 강아지의 좌표
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    y = i;
                    x = j;
                }
                if(board[i][j] == 3) {
                    dogY = i;
                    dogX = j;
                }
            }
        }
        int idx = 0;
        int dogIdx = 0;
        // 2. 시뮬레이션
        while(max-- > 0) {
            count++;
            int ny = y + dy[idx];
            int nx = x + dx[idx];
            int dogNy = dogY + dy[dogIdx];
            int dogNx = dogX + dx[dogIdx];
            if(ny < 0 || ny >= 10 || nx < 0 || nx >= 10 || board[ny][nx] == 1) {
                idx = (idx + 1) % 4;
            } else {
                y = ny;
                x = nx;
            }
            if(dogNy < 0 || dogNy >= 10 || dogNx < 0 || dogNx >= 10 || board[dogNy][dogNx] == 1) {
                dogIdx = (dogIdx + 1) % 4;
            } else {
                dogY = dogNy;
                dogX = dogNx;
            }
            if(y == dogY && x == dogX) {
                answer = count;
                break;
            }
        }
        return answer;
    }

    /**
     * 강사님 풀이
     */
    public int solByTeacher(int[][] board) {
        int n = board.length;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int y1 = 0, x1 = 0, y2 = 0, x2 = 0;
        // 1. 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    y1 = i;
                    x1 = j;
                }
                if (board[i][j] == 3) {
                    y2 = i;
                    x2 = j;
                }
            }
        }
        // 2. 시뮬레이션
        int d1 = 0, d2 = 0, count = 0;
        while (count < 10000) {
            count++;
            int ny1 = y1 + dy[d1];
            int nx1 = x1 + dx[d1];
            int ny2 = y2 + dy[d2];
            int nx2 = x2 + dx[d2];
            boolean flag1 = true, flag2 = true;
            if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[ny1][nx1] == 1) {
                d1 = (d1 + 1) % 4;
                flag1 = false;
            }
            if (nx2< 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[ny2][nx2] == 1) {
                d2 = (d2 + 1) % 4;
                flag2 = false;
            }
            if (flag1 == true) {
                y1 = ny1;
                x1 = nx1;
            }
            if (flag2 == true) {
                y2 = ny2;
                x2 = nx2;
            }
            if(x1 == x2 && y1 == y2) break;
        }
        if(count >= 10000) return 0;
        return count;
    }

    public static void main(String[] args){
        잃어버린강아지_3 T = new 잃어버린강아지_3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solByTeacher(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solByTeacher(arr2));
    }
}
