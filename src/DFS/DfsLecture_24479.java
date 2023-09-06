package DFS;

import java.io.*;
import java.util.*;
public class DfsLecture_24479 {

    final static int MAX = 100000 + 10;

    // 단순 2차원 배열은 메모리 초과가 나니까 ArrayList로 대체한다.
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int N, M, R;
    static int u, v;
    static int order;

    public static void dfs(int idx){
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 1. graph에 연결 정보 채우기
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. 오름 차순 정렬
        for(int i = 1; i <= N; i++)
            Collections.sort(graph[i]);

        // 3. dfs 호출
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
