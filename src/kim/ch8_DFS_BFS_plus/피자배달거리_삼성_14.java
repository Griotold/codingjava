package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 피자배달거리_삼성_14 {
    static int N, M, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs, pz;
    public void DFS(int L, int s) {
        if (L == M) {
            int sum = 0; // 도시의 피자 배달 거리
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.y - pz.get(i).y) + Math.abs(h.x - pz.get(i).x));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s; i < len; i++){
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        피자배달거리_삼성_14 T = new 피자배달거리_삼성_14();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) hs.add(new Point(i, j));
                else if(tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[M];
        T.DFS(0, 0);
        System.out.println(answer);
        br.close();
    }
}
