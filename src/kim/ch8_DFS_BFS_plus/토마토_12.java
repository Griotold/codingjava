package kim.ch8_DFS_BFS_plus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/***
 *
 * 출발점이 여러 개면 큐에 미리 넣어놓는다
 * BFS가 끝났는데 map 0이 하나라도 있다면 -1
 */

public class 토마토_12 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> Q = new LinkedList<>();

    public void BFS() {
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = tmp.y+ dy[i];
                int nx = tmp.x+ dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m &&
                        board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    Q.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        토마토_12 T = new 토마토_12();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
                if(board[i][j] == 1) Q.offer(new Point(i, j));
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);

    }
}
