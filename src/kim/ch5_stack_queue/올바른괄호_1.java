package kim.ch5_stack_queue;

import java.util.Stack;

public class 올바른괄호_1 {

    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == '(') stack.push(ch);
            else {
                if(stack.empty()) return "NO";
                else stack.pop();
                // stack.pop(); --> 굳이 else에 넣지 않아도 된다.
            }
        }
        if (!stack.empty()) answer = "NO";
        return answer;
    }
}
