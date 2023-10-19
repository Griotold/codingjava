import kim.ch8_DFS_BFS_plus.수열추측하기_8;

import java.io.*;
import java.util.*;

public class Main {
    // 4 2
    static int N, M;
    static int[] combi;

    public void DFS(int L, int S) {
        if(L == M) {
            for (int x : combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = S; i <= N; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        T.DFS(0, 1);
        br.close();
    }
}