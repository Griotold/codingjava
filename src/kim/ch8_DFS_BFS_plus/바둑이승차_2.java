package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이승차_2 {
    // static int answer = Integer.MIN_VALUE;
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
    /**
     * 다른 풀이 - 거의 같음
     * */
    public void DFSByTeacher(int L, int sum) {
        if(sum < C) return;
        if (L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        바둑이승차_2 T = new 바둑이승차_2();
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
