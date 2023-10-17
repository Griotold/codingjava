import java.io.*;
import java.util.*;

public class Main {
    // 259 5
    //81
    //58
    //42
    //33
    //61
    static int C, N, answer;
    static int[] arr;
    public void DFS(int L, int sum) {
        if(L == N) {
            if(C > sum)
                answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        T.DFS(0, 0);
        System.out.println(answer);
        br.close();
    }
}