package it_big_company_problem.ch2_hash;

import java.util.*;

public class 문서도난_6 {
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }

    public String[] solution(String[] reports, String times){
        // 1. HH:MM -> 분으로 파싱
        ArrayList<Info> tmp = new ArrayList<>();
        for (String x : reports) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }

        // 2. 정렬
        Collections.sort(tmp);

        // 3. 특정 범위 또한 파싱
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);

        // 4. 범위 안에 들어가는 사람 리스트에 담기
        ArrayList<String> res = new ArrayList<>();
        for (Info ob : tmp) {
            if (ob.time >= s && ob.time <= e) {
                res.add(ob.name);
            }
            if (ob.time > e) break;
        }

        // 5. String[]으로 변환 후 리턴
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        문서도난_6 T = new 문서도난_6();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
