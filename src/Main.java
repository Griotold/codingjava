import java.io.*;
import java.util.*;

public class Main {
    // 8
    //5 3 7 8 6 2 9 4 --> 4
    static int N;
    static int[] dp, arr;
    public int sol() {
        int answer = 0;
        dp[0] = 1;
        for(int i = 1; i < N; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dp[j] > max) max = dp[j];
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.sol());
        br.close();
    }
}