package baekjoon.DFS;

import java.io.*;
import java.util.*;

public class 침투_13565 {

    static final int MAX = 1000 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean flag = false;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        if(y == N) {
            flag = true;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(map[ny][nx] && !visited[ny][nx])
                dfs(ny, nx);
        }
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];

        // 1. map 정보 반영
        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = (str.charAt(j - 1) == '0') ? true : false;
            }
        }

        // 2. dfs 수행
        for(int j = 1; j <= M; j++){
            if(map[1][j] && !visited[1][j])
                dfs(1, j);
        }

        // 3. 출력
        if(flag) bw.write("YES");
        else bw.write("NO");
        br.close();
        bw.close();
    }
}
