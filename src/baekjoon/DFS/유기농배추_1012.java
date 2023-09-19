package baekjoon.DFS;

import java.io.*;
import java.util.*;
public class 유기농배추_1012 {

    // MAX map visited T N M K dy dx
    static final int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int T, N, M, K;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(map[ny][nx] && !visited[ny][nx])
                dfs(ny, nx);
        }
    }

    public static void logic() throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 1. map 정보
            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true;
            }

            // 2. dfs 수행
            int answer = 0;
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    if(map[i][j] && visited[i][j] == false) {
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
