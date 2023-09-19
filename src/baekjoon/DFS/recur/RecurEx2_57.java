package baekjoon.DFS.recur;

import java.io.*;
/**
 * 57. 재귀함수로 이진수 출력
 * */
public class RecurEx2_57 {

    static int N;

    public static void dfs(int idx) {
        if (idx == 1) {
            System.out.print(idx);
        } else {
            dfs(idx / 2);
            System.out.print(idx % 2);
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
