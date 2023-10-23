
import kim.ch9_greedy.Lecture;

import java.io.*;
import java.util.*;


public class Main {
    // 6
    //50 2
    //20 1
    //40 2
    //60 3
    //30 3
    //30 1 --> 150
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
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
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