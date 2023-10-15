import java.io.*;
import java.util.*;

public class Main {
    // 5 14 -> 3
    int[] range = {-1, 1, 5};
    int[] ch = new int[10001];
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int S, int E) {
        ch[S] = 1;
        Q.offer(S);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int x = Q.poll();
                for(int j = 0; j < 3; j++) {
                    int nx = x + range[j];
                    if(nx == E) return L + 1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
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
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(S, E));
        br.close();
    }
}