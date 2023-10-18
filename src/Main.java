import java.io.*;
import java.util.*;

public class Main {
    // 3
    // 1 2 5
    // 15 --> 3
    static int N, M, answer=Integer.MAX_VALUE;
    static boolean flag = false;
    static Integer[] coins;

    public void DFS(int L, int sum) {
        if(flag == true) return;
        if(sum > M) return;
        if(sum == M) {
            answer = Math.min(answer, L);
            flag = true;
        }
        else {
            for(int i = 0 ; i < N; i++) {
                DFS(L + 1, sum + coins[i]);
                DFS(L + 1, sum);
            }
        }
    }
    public void DFSByTeacher(int L, int sum) {
        if(sum > M) return;
        if(L>=answer) return;
        if(sum == M) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < N; i++){
                DFSByTeacher(L + 1, sum + coins[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        coins = new Integer[N];
        for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(coins, Collections.reverseOrder());
        M = Integer.parseInt(br.readLine());
        T.DFSByTeacher(0, 0);
        System.out.println(answer);
        br.close();
    }
}