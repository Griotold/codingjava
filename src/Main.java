import kim.ch8_DFS_BFS_plus.Point;

import java.io.*;
import java.util.*;


public class Main {
    // 6 4
    //0 0 -1 0 0 0
    //0 0 1 0 -1 0
    //0 0 -1 0 0 0
    //0 0 0 0 -1 1 --> 4
    static final int MAX = 1000 + 10;
    static int N, M, answer;
    static int[][] map = new int[MAX][MAX];
    static int[][] ch = new int[MAX][MAX];
    static int[][] dis = new int[MAX][MAX];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public void BFS(int y, int x) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(y, x));
        ch[y][x] = 1;
        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = tmp.y + dy[i];
                int nx = tmp.x + dx[i];
                if(ny >= 1 && ny <= N && nx >= 1 && nx <= M &&
                ch[ny][nx] == 0 && map[ny][nx] == 0) {
                    ch[ny][nx] = 1;
                    dis[ny][nx] = Math.min(dis[y][x] + 1, dis[ny][nx]);
                    Q.offer(new Point(ny, nx));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(map[i][j] == 1) {
                    T.BFS(i, j);
                }
                ch = new int[MAX][MAX];
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                answer = Math.max(dis[i][i], answer);
            }
        }
        System.out.println(answer);
        br.close();
    }
}