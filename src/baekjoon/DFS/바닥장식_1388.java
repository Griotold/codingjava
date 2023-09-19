package baekjoon.DFS;
import java.io.*;
import java.util.*;

public class 바닥장식_1388 {

    static final int MAX = 50 + 10;
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static void rightDfs(int y, int x) {
        visited[y][x] = true;
        if(map[y][x + 1] == '-' && !visited[y][x + 1])
            rightDfs(y, x + 1);
    }
    static void downDfs(int y, int x) {
        visited[y][x] = true;
        if(map[y + 1][x] == '|' && !visited[y + 1][x])
            downDfs(y + 1, x);
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] == '-' && !visited[i][j]) {
                    answer++;
                    rightDfs(i, j);
                }
                if(map[i][j] == '|' && !visited[i][j]) {
                    answer++;
                    downDfs(i, j);
                }
            }
        }
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
