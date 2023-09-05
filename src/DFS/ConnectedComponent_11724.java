package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class ConnectedComponent_11724 {

    static boolean[][] graph;

    static boolean[] visited;

    static int N, M;

    static int cnt = 0;

    public static void dfs(int idx) {
        for(int i = 1; i <= N; i++){
            if (visited[i] == false && graph[idx][i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void logic() throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // graph
        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // DFS 호출
        for (int i = 1; i <= N; i++) {
            if(visited[i] == false) {
                cnt++;
                visited[i] = true;
                dfs(i);
            }

        }

        // return answer
        bw.write(String.valueOf(cnt));

        br.close();
        bw.close();
    }
}
