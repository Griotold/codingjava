package kim.ch10_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌다리건너기_2 {
    static int N;
    static int[] dp;
    public int DFS(int N) {
        if(dp[N] != 0) return dp[N];
        if(N == 1) return 1;
        if(N == 2) return 2;
        else {
            return dp[N] = DFS(N - 1) + DFS(N - 2);
        }
    }

    public int solByTeacher(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i = 2];
        }
        return dp[n + 1];
    }

    public static void main(String[] args) throws IOException {
        돌다리건너기_2 T = new 돌다리건너기_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        System.out.println(T.DFS(N + 1));
        br.close();
    }
}
