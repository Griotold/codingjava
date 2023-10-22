package kim.ch9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 이중 for문으로 하는 단순한 풀이는 타임 리미트에 걸린다
 * */
public class 씨름선수_1 {
    static int N;
    static ArrayList<Player> list;

    /**
     * 내 풀이 - 이중 for문으로 푼 풀이
     * 시간복잡도 : O(N^2)
     * */
    public int sol() {
        int answer = 0;
        for(int i = 0; i < N; i++) {
            Player now = list.get(i);
            boolean flag = true;
            for(int j = 0 ; j < N; j++) {
                if(i == j) continue;
                Player tmp = list.get(j);
                if(now.height < tmp.height && now.weight < tmp.weight) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
    /**
     * greedy 풀이법 - 시간복잡도 : O(N)
     * 좌표 정렬
     * */
    public int solByTeacher() {
        // 1. 일단 내림차순 정렬
        Collections.sort(list);
//        for (Player player : list) {
//            System.out.println(player.height + " : " + player.weight);
//        }
        int answer = 1;
        int max = list.get(0).weight;
        // 2.
        for(int i = 1 ; i < N; i++) {
            int weight = list.get(i).weight;
            if(max < weight) {
                answer++;
                max = weight;
            }
        }
        return answer;
    }

    /**
     * greedy - 향상된 for문
     */
    public int solByTeacherReal() {
        int cnt = 0;
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for (Player player : list) {
            if (player.weight > max) {
                max = player.weight;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        씨름선수_1 T = new 씨름선수_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Player(h, w));
        }
        System.out.println(T.sol());
        System.out.println(T.solByTeacher());
        br.close();
    }
}
