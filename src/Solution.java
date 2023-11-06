import java.util.*;

class Solution {
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

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }

}
