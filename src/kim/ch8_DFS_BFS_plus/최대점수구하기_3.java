package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 클래스를 하나 만들어서 사용하는게 나아보인다.
 * 점수 따로, 시간 따로 배열 만드는건 별로인 듯
 * */
public class 최대점수구하기_3 {
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
        최대점수구하기_3 T = new 최대점수구하기_3();
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
class Problem {
    int point;
    int time;
    public Problem(int p, int t) {
        point = p;
        time = t;
    }
}
