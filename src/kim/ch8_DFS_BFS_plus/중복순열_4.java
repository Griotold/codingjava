package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중복순열_4 {
    static int N, M;
    static int[] permutation;

    public void DFS(int L) {
        if(L == M) {
            for(int x : permutation) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                permutation[L] = i;
                DFS(L + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        중복순열_4 T = new 중복순열_4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        permutation = new int[M];
        T.DFS(0);
        br.close();
    }
}
