import java.util.*;

class Solution {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int y = 0, x = 0, d = 1, count = 1;
        int[][] seat = new int[c][r];
        seat[y][x] = count;
        while(k - count > 0) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= c || nx < 0 || nx >= r || seat[ny][nx] > 0) {
                d = (d + 1) % 4;
            }
            ny = y + dy[d];
            nx = x + dx[d];
            count++;
            seat[ny][nx] = count;
            y = ny;
            x = nx;
            if(count == k) {
                answer[0] = y + 1;
                answer[1] = x + 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
