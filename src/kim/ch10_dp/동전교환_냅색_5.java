package kim.ch10_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전교환_냅색_5 {
    static int N, M;
    static int[] dp;
    public int sol(int[] coin) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }
        return dp[M];
    }

    public static void main(String[] args) throws IOException {
        동전교환_냅색_5 T = new 동전교환_냅색_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        dp = new int[M + 1];
        System.out.println(T.sol(arr));
        br.close();
    }
}
