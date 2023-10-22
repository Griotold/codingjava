package kim.ch9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 결혼식_3 {
    static int N;
    static ArrayList<Wedding> list = new ArrayList<>();
    /**
     * 내 풀이 - 오답이라고 하는데 정답과 비교해봐도 뭐가 틀린지 모르겠음
     * */
    public int sol() {
        int answer = 0;
        int cnt = 0;
        Collections.sort(list);
        for(int i = 0 ; i < N; i++) {
            Wedding wedding = list.get(i);
            if(wedding.state.equals("s")) cnt++;
            else cnt--;
            if(cnt > answer) answer = cnt;
        }
        return answer;
    }
    /**
     * 정답 풀이
     * */
    public int solByTeacher() {
        int answer = Integer.MIN_VALUE;
        Collections.sort(list);
        int cnt = 0;
        for (Wedding wedding : list) {
            if(wedding.state.equals("s")) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        결혼식_3 T = new 결혼식_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Wedding(start, "s"));
            list.add(new Wedding(end, "e"));
        }
//        Collections.sort(list);
//        for (Wedding wedding : list) {
//            System.out.println(wedding.time + " : " + wedding.state);
//        }
        System.out.println(T.sol());
        br.close();
    }
}
