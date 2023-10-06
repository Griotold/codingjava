import java.io.*;
import java.util.*;
public class Main {
    // 352+*9-  --> 12
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
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str));
        br.close();
    }
}