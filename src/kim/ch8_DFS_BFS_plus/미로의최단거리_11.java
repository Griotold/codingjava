package kim.ch8_DFS_BFS_plus;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의최단거리_11 {
    static int[][] map = new int[8][8];
    static int[][] dis = new int[8][8];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public void BFS(int y, int x) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(y, x));
        map[y][x] = 1;
        while (!Q.isEmpty()) {
            Point point = Q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                if(ny >= 1 && ny <= 7 && nx >= 1 && nx <= 7 &&
                        map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    dis[ny][nx] = dis[point.y][point.x] + 1;
                    Q.offer(new Point(ny, nx));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        미로의최단거리_11 T = new 미로의최단거리_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.BFS(1, 1);
        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
        br.close();
    }
}

