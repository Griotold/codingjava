import java.io.*;
import java.util.*;
public class Main {
    // (()(()))(() --> NO
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()) {
            if(ch == '(') stack.push(ch);
            else {
                if(stack.empty()) return "NO";
                else stack.pop();
            }
        }
        if (!stack.empty()) answer = "NO";
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