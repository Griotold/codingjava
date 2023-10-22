
import kim.ch9_greedy.MeetingTime;
import kim.ch9_greedy.Wedding;

import java.io.*;
import java.util.*;


public class Main {
    // 5
    //14 18
    //12 15
    //15 20
    //20 30
    //5 14 -- > 2
    static int N;
    static ArrayList<Wedding> list = new ArrayList<>();

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

    public static void main(String[] args) throws IOException {
        Main T = new Main();
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