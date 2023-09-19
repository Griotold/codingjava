package baekjoon.DFS;

import java.util.*;
import java.io.*;

public class 트리의부모찾기_11725_2 {

    static final int MAX = 100000 + 10;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int N;

    public static void dfs(int idx) {
        visited[idx] = true;

        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if(visited[next] == false) {
                answer[next] = idx;
                dfs(next);
            }
        }
    }

    public static void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[MAX];
        visited = new boolean[MAX];
        answer = new int[MAX];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int u, v;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);

        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
