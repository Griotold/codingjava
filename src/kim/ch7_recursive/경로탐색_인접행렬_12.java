package kim.ch7_recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로탐색_인접행렬_12 {

    static int N, M, count;
    static int[][] graph;
    static int[] ch;
    static ArrayList<Integer> answer = new ArrayList<>();

    public void DFS(int node) {
        ch[node] = 1;
        answer.add(node);
        if(node == N) {
            count++;
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= N; i++) {
                if(graph[node][i] == 1 && ch[i] == 0) {
                    DFS(i);
                    ch[i] = 0;
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        경로탐색_인접행렬_12 T = new 경로탐색_인접행렬_12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        ch = new int[N + 1];
        count = 0;
        T.DFS(1);
        System.out.println("count = " + count);
        br.close();
    }
}
