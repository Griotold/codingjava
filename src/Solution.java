import java.util.*;

class Solution {

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

    public static void main(String[] args){
        Solution T = new Solution();
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
        System.out.println(T.solution(arr1));
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
        System.out.println(T.solution(arr2));
    }
}
