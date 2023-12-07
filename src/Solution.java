import java.util.*;

class Solution {
    public String[] solution(String[] reports, String times){
        String[] answer = {};
        String start = times.split(" ")[0];
        String end = times.split(" ")[1];
        int startHour = Integer.parseInt(start.split(":")[0]);
        int startMinute = Integer.parseInt(start.split(":")[1]);
        int s = startHour * 60 + startMinute;
        int endHour = Integer.parseInt(end.split(":")[0]);
        int endMinute = Integer.parseInt(end.split(":")[1]);
        int e = endHour * 60 + endMinute;

        // 1. 해싱
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : reports) {
            String person = str.split(" ")[0];
            String time = str.split(" ")[1];
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            int totalMinute = hour * 60 + minute;
            map.put(person, totalMinute);
        }

        // 2. 정렬

        // 3. 조건에 만족하는 것 담기


        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
//        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
//        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
