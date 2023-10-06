package kim.ch5_stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 공주구하기_6 {
    /**
     * ArrayList를 Queue처럼 사용해서 풀기
     * */
    public int solByArrayList(int n, int k) {
        int answer = 0;
        List<Integer> queue = new ArrayList<>();
        for(int i = 1; i <= n; i++) queue.add(i);
        while(!queue.isEmpty()) {
            for(int i = 1; i < k; i++) queue.add(queue.remove(0));
            queue.remove(0);
            if(queue.size() == 1) answer = queue.remove(0);
        }
        return answer;
    }
    /**
     * 강사님 풀이
     */
    public int solByTeacher(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= n; i++) Q.offer(i);
        while (!Q.isEmpty()) {
            for(int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }
        return answer;
    }
    /**
     * 내 풀이
     * */
    public int solution(int N, int K) {
        int answer = 0, count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while(queue.size() != 1) {
            count++;
            if(count == K) {
                queue.poll();
                count = 0;
            }
            else queue.offer(queue.poll());
        }
        answer = queue.poll();
        return answer;
    }
}
