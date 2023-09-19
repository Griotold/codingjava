package baekjoon.DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기_2667 {

    static final int MAX = 25 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int countPerDanzi;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        countPerDanzi++;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (map[ny][nx] && !visited[ny][nx])
                dfs(ny, nx);
        }
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            for(int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1) == '1';
            }
        }

        ArrayList<Integer> countList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if (map[i][j] && !visited[i][j]){
                    countPerDanzi = 0;
                    dfs(i, j);
                    countList.add(countPerDanzi);
                }
            }
        }
        bw.write(String.valueOf(countList.size()));
        bw.newLine();
        Collections.sort(countList);
        for (int count : countList) {
            bw.write(String.valueOf(count));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
