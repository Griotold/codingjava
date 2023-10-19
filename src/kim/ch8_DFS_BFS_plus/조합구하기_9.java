package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 재귀를 활용한 조합은 암기하는게 좋다
 * */
public class 조합구하기_9 {
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
        조합구하기_9 T = new 조합구하기_9();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        T.DFS(0, 1);
        br.close();
    }
}
