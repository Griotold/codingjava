package DFS;

import java.io.*;
import java.util.*;
public class DfsLecture_24480 {

    static final int MAX = 100000 + 10;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    static int N, M, R, order;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = order++;
        for(int i = 0; i < graph[idx].size(); i++){
            int next = graph[idx].get(i);
            if(visited[next] == false)
                dfs(next);
        }
    }

    public static void logic() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 1. graph 초기화
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        // 2. 내림차순
        for(int i = 1; i <= N; i++)
            Collections.sort(graph[i], Comparator.reverseOrder());

        // 3. DFS 호출
        dfs(R);

        // 4. 출력
        for(int i = 1; i <= N; i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
