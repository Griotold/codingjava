package kim.ch9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PriorityQueue 활용
 * */
public class 최대수입스케줄_4 {

    static int N;
    static ArrayList<Lecture> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int sol() {
        int answer = 0;
        Collections.sort(list);
        int max = list.get(0).time;
        for(int i = max; i >= 1; i--) {
            while(!list.isEmpty()) {
                Lecture lecture = list.get(0);
                if(lecture.time < i) break;
                pq.offer(lecture.money);
                list.remove(0);
            }
            if(!pq.isEmpty()) answer += pq.poll(); // 런타임 에러 주의
        }
        return answer;
    }
    /**
     * 강사님 풀이
     * */
    public int solByTeacher() {
        int answer = 0;
        Collections.sort(list);
        int j = 0;
        int max = list.get(0).time;
        for(int i = max; i >= 1; i--){
            for( ; j < N; j++) {
                if(list.get(j).time < i) break;
                pq.offer(list.get(j).money);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        최대수입스케줄_4 T = new 최대수입스케줄_4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.add(new Lecture(money, time));
        }
//        Collections.sort(list);
//        for (Lecture lecture : list) {
//            System.out.println(lecture.money + " : " + lecture.time);
//        }
        System.out.println(T.sol());
        br.close();
    }
}
