package DFS;

import java.io.*;
import java.util.*;

public class DFSandBFS_1260 {

    static final int MAX = 1000 + 10;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> queue;
    static boolean[] visited;
    static int N, M, V;

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for(int i = 0; i < graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(visited[next] == false)
                dfs(next);
        }
    }

    public static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[MAX];

        queue.add(V);
        visited[V] = true;

        while(!queue.isEmpty()) {
            int idx = queue.remove(0);
            System.out.print(idx + " ");

            for(int i = 0; i < graph[idx].size(); i++){
                int next = graph[idx].get(i);
                if(visited[next] == false) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }

    public static void logic() throws IOException {
        // 0. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 1. graph
        graph = new ArrayList[MAX];
        visited = new boolean[MAX];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        // 2. dfs 호출
        dfs(V);
        System.out.println();

        // 3. bfs 호출
        bfs();

        br.close();
        bw.close();
    }
}
