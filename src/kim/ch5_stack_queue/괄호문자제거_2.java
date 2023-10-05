package kim.ch5_stack_queue;

import java.util.Stack;

public class 괄호문자제거_2 {
    /**
     * 내 풀이 - 무조건 올바른 괄호가 들어온다고 가정하고 풂
     *        - 통과는 되었지만 엄밀한 풀이는 아님
     * */
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x == '(') stack.push(x);
            else if(x == ')') {
                stack.pop();
            }
            else
            if(stack.isEmpty()) answer += x;
        }
        return answer;
    }
    /**
     * 강사님 풀이 - 엄밀한 풀이
     * */
    public String sol2(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if (x == ')') {
                while(stack.pop() != '(');
            } else stack.push(x);
        }

        // for(char x : stack) answer += x;
        for(int i = 0; i < stack.size(); i++){
            answer += stack.get(i);
        }
        return answer;
    }
}
