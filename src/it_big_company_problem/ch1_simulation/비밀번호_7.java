package it_big_company_problem.ch1_simulation;

import java.util.Arrays;
/**
 * 힌트듣고 구현은 되는데 풀이법을 구상하는 연습이 필요
 * */
public class 비밀번호_7 {
    /**
     * 내 풀이
     * */
    public int solution(int[] keypad, String password){
        int answer = 0;
        // 1. 2차원 배열로 파싱
        int[][] keypad2 = new int[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypad2[i][j] = keypad[k + j];
            }
            k += 3;
        }
        // 2. dist 배열 초기화 0초, 2초
        int[][] dist = new int[10][10];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], 2);
        }
        for(int i = 0; i < 10; i++) dist[i][i] = 0;
        // 3. dist 배열 1초 걸리는 곳 세팅
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for(int u = 0; u < 8; u++){
                    int ny = i + dy[u];
                    int nx = j + dx[u];
                    if(ny >= 0 && ny < 3 && nx >= 0 && nx < 3){
                        dist[keypad2[i][j]][keypad2[ny][nx]] = 1;
                    }
                }
            }
        }
        // 4. password 탐색하여 answer 계산
        for (int i = 0; i < password.length() - 1; i++) {
            char ch = password.charAt(i);
            char ch2 = password.charAt(i+1);
            int now = ch - 48;
            int next = ch2 - 48;
            answer += dist[now][next];
        }
        return answer;
    }

    /**
     * 정답
     */
    public int solByTeacher(int[] keypad, String password) {
        int answer = 0;
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        // 1. 2차원 배열로 키패드를 변환 -> i, j 만으로 구현 가능!
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }
        // 2. dist 배열 0, 2 초기화
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for(int i = 0; i < 10; i++) dist[i][i] = 0;

        // 3. dist 배열 근접한 곳 1로 초기화
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    int ny = i + dy[k];
                    int nx = i + dx[k];
                    if(ny >= 0 && ny < 3 && nx >= 0 && nx < 3){
                        int to = pad[ny][nx];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        // 4. password 탐색하면서 answer 계산
        for (int i = 1; i < password.length(); i++) {
            int from = (int)password.charAt(i - 1) - 48;
            int to = (int)password.charAt(i) - 48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args){
        비밀번호_7 T = new 비밀번호_7();
        System.out.println(T.solByTeacher(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solByTeacher(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solByTeacher(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solByTeacher(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
