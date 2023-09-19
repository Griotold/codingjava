package baekjoon.DFS.recur;

import java.io.*;

public class RecurEx1 {

    static int N;

    public static void dfs(int idx) {
        if (idx == 0) {
            return;
        } else {
            dfs(idx - 1);
            System.out.print(idx + " ");
        }
    }

    public static void logic() throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 재귀함수 호출
        dfs(N);

        br.close();
        bw.close();
    }

}
