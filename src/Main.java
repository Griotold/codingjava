import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 7 -> 34
    static int N;
    static int[] dp;
    public int DFS(int N) {
        if(dp[N] != 0) return dp[N];
        if(N == 1) return 1;
        if(N == 2) return 2;
        else {
            return dp[N] = DFS(N-1) + DFS(N-2);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        System.out.println(T.DFS(N+1));
        br.close();
    }
}