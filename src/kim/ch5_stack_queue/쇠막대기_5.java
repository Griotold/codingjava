package kim.ch5_stack_queue;

import java.util.Stack;

public class 쇠막대기_5 {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') stack.push(ch);
            else {
                char pre = str.charAt(i - 1);
                stack.pop();
                if(pre == '('){
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
