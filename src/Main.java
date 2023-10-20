import java.io.*;
import java.util.*;


public class Main {
    // 7
    //1 1 0 0 0 1 0
    //0 1 1 0 1 1 0
    //0 1 0 0 0 0 0
    //0 0 0 1 0 1 1
    //1 1 0 1 1 0 0
    //1 0 0 0 1 0 0
    //1 0 1 0 1 0 0 --> 5
    static int N, answer;
    static int[][] map;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int y, int x) {
        for(int i = 0 ; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < N && nx >= 0 && nx < N &&
            map[ny][nx] == 1) {
                map[ny][nx] = 0;
                DFS(ny, nx);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    answer++;
                    map[i][j] = 0;
                    T.DFS(i, j);
                }
            }
        }
        System.out.println(answer);
        br.close();
    }
}