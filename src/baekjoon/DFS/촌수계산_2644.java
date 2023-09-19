package baekjoon.DFS;

import java.io.*;
import java.util.*;

public class 촌수계산_2644 {

    static final int MAX = 100 + 10;
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M, start, end, answer;

    public static void dfs(int idx, int count) {
        visited[idx] = true;
        if(idx == end) {
            answer = count;
        } else {
            for(int i = 1; i <= N; i++){
                if(visited[i] == false && graph[idx][i] == true) {
                    dfs(i, count + 1);
                }
            }
        }
    }

    public static void logic() throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        // 1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        // 2. dfs 호출
        answer = -1;
        dfs(start, 0);

        // 3. 출력
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
