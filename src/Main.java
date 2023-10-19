import java.io.*;
import java.util.*;

public class Main {
    // 5 3 --> 10
    static int N, M;
    static int[][] dy;

    public int DFS(int n, int r) {
        if(dy[n][r] != 0) return dy[n][r];
        if(r == 0 || n == r) return dy[n][r] = 1;
        else {
            return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dy = new int[N + 1][N + 1];
        System.out.println(T.DFS(N, M));
        br.close();
    }
}