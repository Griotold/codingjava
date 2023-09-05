package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class Virus_2606 {

    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer++;

        for (int i = 1; i <= N; i++) {
            if(visited[i] == false && graph[idx][i])
                dfs(i);
        }
    }

    public static void logic() throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // graph
        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // DFS 호출
        dfs(1);

        // return answer
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

}
