import java.io.*;
import java.util.*;

public class Main {
    // 6 9
    //1 3
    //1 4
    //2 1
    //2 5
    //3 4
    //4 5
    //4 6
    //6 2
    //6 5
    static int N, M, count = 0;
    static int[][] graph;
    static int[] ch;
    static int[] answer;
    public int BFS(int v, int target) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int now = Q.poll();
                for(int j = 1; j <= N; j++) {
                    if(graph[now][j] == 1 && ch[j] == 0){
                        if(j == target) return L + 1;
                        ch[j] = 1;
                        Q.offer(j);
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        answer = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        for(int i = 2; i <= N; i++) {
            ch = new int[N + 1];
            ch[1] = 1;
            System.out.println(i + " : " + T.BFS(1, i));
        }

        br.close();
    }
}