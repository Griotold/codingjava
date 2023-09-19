package baekjoon.DFS;

import java.util.*;
import java.io.*;

public class 트리의부모찾기_11725 {

    static final int MAX = 100000 + 10;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;
    static int N;

    public static void dfs(int idx, int prev) {
        visited[idx] = true;
        parents[idx] = prev;

        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if(visited[next] == false)
                dfs(next, idx);
        }
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        parents = new int[MAX];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, 0);

        for(int i = 2; i <= N; i++){
            bw.write(String.valueOf(parents[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
