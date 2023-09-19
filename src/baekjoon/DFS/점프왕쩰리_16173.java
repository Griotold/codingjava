package baekjoon.DFS;

import java.io.*;
import java.util.*;

public class 점프왕쩰리_16173 {

    static final int MAX = 3 + 100 + 10;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int N;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        if(y == N && x == N) {
            flag = true;
            return;
        }
        int step = map[y][x];
        if(y + step <= N && !visited[y + step][x]) dfs(y + step, x);
        if(x + step <= N && !visited[y][x + step]) dfs(y, x + step);
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 1);

        if(flag) bw.write("HaruHaru\n");
        else bw.write("Hing\n");

        br.close();
        bw.close();
    }
}
