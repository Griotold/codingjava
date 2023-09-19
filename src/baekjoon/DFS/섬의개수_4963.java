package baekjoon.DFS;

import java.io.*;
import java.util.*;

public class 섬의개수_4963 {

    static final int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 8; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(map[ny][nx] && !visited[ny][nx])
                dfs(ny, nx);
        }
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 0. 테스트 케이스
        while(true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) break;

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                }
            }

            // 2. dfs 수행
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++){
                    if(map[i][j] && !visited[i][j]) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
