import java.io.*;
import java.util.*;
public class Main {
    // ()(((()())(())()))(()) -> 17
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
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str));
        br.close();
    }
}