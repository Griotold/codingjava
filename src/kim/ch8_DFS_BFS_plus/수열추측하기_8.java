package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열추측하기_8 {
    static int N, F;
    static int[] b, p, ch; // 이항계수 배열, 순열 배열, 체크 배열
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if (L == N) {
            if(sum == F) {
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum+(p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        수열추측하기_8 T = new 수열추측하기_8();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        b = new int[N];
        p = new int[N];
        ch = new int[N + 1];
        for (int i = 0; i < N; i++) {
            b[i] = T.combi(N - 1, i);
        }
        T.DFS(0, 0);
        br.close();
    }
}
