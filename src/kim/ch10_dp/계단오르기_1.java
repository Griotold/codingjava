package kim.ch10_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_1 {
    static int N;
    static int[] dp;
    /**
     * 내 풀이 - 재귀 활용
     */
    public int DFS(int N) {
        if(dp[N] != 0) return dp[N];
        if(N == 1) return 1;
        if(N == 2) return 2;
        else {
            return dp[N] = DFS(N - 1) + DFS(N - 2);
        }
    }

    /**
     * 강사님 풀이 - 반복문 활용
     */
    public int solByTeacher(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        계단오르기_1 T = new 계단오르기_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.println(T.DFS(N));
        br.close();
    }
}
