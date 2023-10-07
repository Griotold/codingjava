package kim.ch5_stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 응급실_8 {
    /**
     * 내 풀이 - 어쨌든 안보고 풀었다!
     * */
    public int sol(int N, int M, int[] arr) {
        int answer = 1;
        List<Person> queue = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            queue.add(new Person(i, arr[i]));
        }
        while(true) {
            Person now = queue.remove(0);
            boolean boom = true;
            for(int i = 0; i < queue.size(); i++){
                Person rest = queue.get(i);
                if(now.ratio < rest.ratio) {
                    queue.add(now);
                    boom = false;
                    break;
                }
            }
            if(boom) {
                if(M == now.order) break;
                else answer++;
            }
        }

        return answer;
    }
    public int solByTeacher(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person x : Q) {
                if (x.ratio > tmp.ratio) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) { // 진료 받을 수 있다면
                answer++;
                if(tmp.order == m) return answer;
            }
        }
        return answer;
    }
    class Person {
        int order; // 강사님은 id
        int ratio; // 강사님은 priority
        public Person(int order, int ratio) {
            this.order = order;
            this.ratio = ratio;
        }
    }
}
