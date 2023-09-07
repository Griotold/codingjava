package DFS;

import java.io.*;
import java.util.*;

public class 점프왕쩰리_16173_2 {

    static final int MAX = 3 + 100 + 10;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static int N;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        if(y == N && x == N) return;
        for(int i = 0; i < 2; i++) {
            int ny = y + dy[i] * map[y][x];
            int nx = x + dx[i] * map[y][x];
            if(!visited[ny][nx])
                dfs(ny, nx);
        }

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

        if(visited[N][N]) bw.write("HaruHaru\n");
        else bw.write("Hing\n");
        br.close();
        bw.close();
    }
}
