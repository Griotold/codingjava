package kim.ch2_array;

public class 격자판최대합_9 {
    /**
     * 내 풀이
     * */
    static int[][] map;
    public int solution(int N, int[][] arr) {
        int answer = 0;
        // 행
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < N; j++) {
                tmp += map[i][j];
            }
            if(tmp > answer) answer = tmp;
        }
        // 열
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < N; j++) {
                tmp += map[j][i];
            }
            if(tmp > answer) answer = tmp;
        }
        int tmp = 0;
        for(int i = 0; i < N; i++) {
            tmp += map[i][i];
        }
        if(tmp > answer) answer = tmp;

        tmp = 0;
        for(int i = 0; i < N; i++) {
            tmp += map[i][N-i-1];
        }
        if(tmp > answer) answer = tmp;
        return answer;
    }
    /**
     * 강사님 풀이
     * */
    public int solution2(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for(int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }


}
