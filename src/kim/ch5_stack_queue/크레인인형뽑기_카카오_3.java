package kim.ch5_stack_queue;

import java.util.Stack;

public class 크레인인형뽑기_카카오_3 {
    /**
     * 내 풀이 - 다 풀어 놓고 +2 해줘야 할거 ++만 해줌
     *        - 정신 차리자
     * */
    public int solution(int N, int[][] board, int M, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < M; i++) {
            int column = moves[i] - 1;
            for(int j = 0; j < N; j++) {
                int top = board[j][column];
                if(top != 0) {
                    if(!stack.isEmpty() && stack.peek() == top){
                        stack.pop();
                        answer += 2; // 여기 ++ 말고 += 2
                    }
                    else {
                        stack.push(top);
                    }
                    board[j][column] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
