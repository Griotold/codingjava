package programmers;

import java.util.ArrayList;
import java.util.List;

public class 프로세스_class활용 {
    public int solution(int[] priorities, int location) {
        // 1. Queue를 만들기
        List<PrintJob> queue = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new PrintJob(priorities[i], i));
        }

        // 2. 0번을 꺼내서 max priority가 아니면 다시 큐에 집어넣기
        int turn = 0;
        while (!queue.isEmpty()) {
            PrintJob first = queue.remove(0);
            if (queue.stream().anyMatch(otherJob -> first.priority < otherJob.priority)) {
                queue.add(first);
            } else {
                // 3. max priority이면 내가 찾는 job location이 맞는지 확인
                turn++;
                if (first.location == location) {
                    break;
                }
            }
        }

        return turn;
    }
    static class PrintJob {
        int priority;
        int location;
        public PrintJob(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
