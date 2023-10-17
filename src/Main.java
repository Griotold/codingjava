import java.io.*;
import java.util.*;
class Problem {
    int point;
    int time;
    public Problem(int p, int t) {
        point = p;
        time = t;
    }
}
public class Main {
    // 5 20
    //10 5
    //25 12
    //15 8
    //6 3
    //7 4 --> 41
    static int N, M;
    static int answer = Integer.MIN_VALUE;
    static ArrayList<Problem> list;
    public void DFS(int L, int sum, int time) {
        if(M < time) return;
        if(L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + list.get(L).point, time + list.get(L).time);
            DFS(L + 1, sum, time);
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.add(new Problem(point, time));
        }
        T.DFS(0, 0, 0);
        System.out.println(answer);
        br.close();
    }
}