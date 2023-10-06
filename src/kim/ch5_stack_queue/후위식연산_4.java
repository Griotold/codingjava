package kim.ch5_stack_queue;

import java.util.Stack;

public class 후위식연산_4 {

    /**
     * 내 풀이
     * */
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if(x >= 48 && x <= 57) stack.push(x - 48);
            else {
                if(x == '+') {
                    int post = stack.pop();
                    int pre = stack.pop();
                    stack.push(pre + post);
                } else if(x == '-'){
                    int post = stack.pop();
                    int pre = stack.pop();
                    stack.push(pre - post);
                } else if(x == '*') {
                    int post = stack.pop();
                    int pre = stack.pop();
                    stack.push(pre * post);
                } else {
                    int post = stack.pop();
                    int pre = stack.pop();
                    stack.push(pre / post);
                }
            }
        }
        answer = stack.pop();
        return answer;
    }

    /**
     * 강사님 풀이 - 더 깔끔함
     */
    public int sol2(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x - 48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }
}
