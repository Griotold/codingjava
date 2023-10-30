package it_big_company_problem.ch1_simulation;

import java.util.Arrays;

public class 좌석번호_4 {
    /**
     * 내 풀이 - 앉을 자리가 없을 때를 처리 못함
     * */
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
    /**
     * 강사님 코드
     * */
    public int[] solByTeacher(int c, int r, int k){
        int[] answer = new int[2];
        if(k > c * r) return new int[] {0, 0}; // 앉을 자리가 없는 경우를 처리!
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while(count < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }
    public static void main(String[] args){
        좌석번호_4 T = new 좌석번호_4();
        System.out.println(Arrays.toString(T.solByTeacher(6, 5, 12)));
        System.out.println(Arrays.toString(T.solByTeacher(6, 5, 20)));
        System.out.println(Arrays.toString(T.solByTeacher(6, 5, 30)));
        System.out.println(Arrays.toString(T.solByTeacher(6, 5, 31)));
    }
}
