package kim.ch8_DFS_BFS_plus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드_BFS_13_2 {
    static int answer = 0, n;
    static int[][] board;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();

    public void BFS(int y, int x) {
        queue.add(new Point(y, x));
        while (!queue.isEmpty()) {
            Point pos = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n &&
                        board[ny][nx] == 1) {
                    board[ny][nx] = 0;
                    queue.add(new Point(ny, nx));
                }
            }
        }
    }
    public void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        섬나라아일랜드_BFS_13_2 T = new 섬나라아일랜드_BFS_13_2();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        T.solution();
        System.out.println(answer);
    }
}
