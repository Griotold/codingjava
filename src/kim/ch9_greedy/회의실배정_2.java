package kim.ch9_greedy;

import kim.ch9_greedy.data.MeetingTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정_2 {
    static int N;
    static ArrayList<MeetingTime> list = new ArrayList<>();

    /**
     * 내 풀이 - 좀 지저분하다
     * */
    public int sol() {
        int answer = 1;
        Collections.sort(list);
//        for (MeetingTime mt : list) {
//            System.out.println(mt.start + " : " + mt.end);
//        }
        int preEnd = list.get(0).end;
        for(int i = 1 ; i < N; i++) {
            MeetingTime mt = list.get(i);
            if(mt.start >= preEnd) {
                answer++;
                preEnd = mt.end;
            }
        }

        return answer;
    }

    /**
     * 강사님 풀이 - 좀 더 간결하다
     */
    public int solByTeacher() {
        int cnt = 0;
        Collections.sort(list);
        int et = 0;
        for (MeetingTime time : list) {
            if (time.start >= et) {
                cnt++;
                et = time.end;
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        회의실배정_2 T = new 회의실배정_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new MeetingTime(start, end));
        }
        System.out.println(T.sol());
        br.close();
    }
}
