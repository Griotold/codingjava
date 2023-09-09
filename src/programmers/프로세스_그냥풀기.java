package programmers;

import java.util.ArrayList;
import java.util.List;

public class 프로세스_그냥풀기 {

    public int solution(int[] priorities, int location) {
        // 1. Queue를 만들기
        List<Integer> queue = new ArrayList<>();
        for (int priority : priorities) {
            queue.add(priority);
        }

        // 2. 0번을 꺼내서 max priority가 아니면 다시 큐에 집어넣기
        int turn = 0;
        while (!queue.isEmpty()) {
            Integer priority = queue.remove(0);
            if (queue.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                queue.add(priority);
            } else {
                turn++;
                // 3. max priority이면 내가 찾는 job location이 맞는지 확인
                if (location == 0) break;
            }
            location--;
            if (location < 0){
                location = queue.size() - 1;
            }
        }
        return turn;
    }
}
