package kim.ch5_stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 교육과정설계_7 {
    /**
     * 내 풀이 - ArrayList를 Queue로 사용
     * */
    public String sol(String str1, String str2) {
        String answer = "NO";
        List<Character> queue = new ArrayList<>();
        for(char ch : str1.toCharArray()) queue.add(ch);
        for(char ch : str2.toCharArray()) {
            if (!queue.isEmpty()) {
                char first = queue.get(0);
                if(ch == first) queue.remove(0);
            }
        }
        if(queue.isEmpty()) answer = "YES";
        return answer;
    }

    /**
     * 강사님 풀이 -
     */
    public String solByTeacher(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) Q.offer(x);
        for (char x : plan.toCharArray()) {
            if(Q.contains(x)) {
                if(x!=Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";
        return answer;
    }
}
