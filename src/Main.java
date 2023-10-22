
import kim.ch9_greedy.MeetingTime;

import java.io.*;
import java.util.*;


public class Main {
    // 5
    //1 4
    //2 3
    //3 5
    //4 6
    //5 7 -- > 3
    static int N;
    static ArrayList<MeetingTime> list = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        Main T = new Main();
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