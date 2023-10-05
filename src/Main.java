import java.io.*;
import java.util.*;
public class Main {
    // (A(BC)D)EF(G(H)(IJ)K)LM(N) --> EFLM
    public String solution(String str) {
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
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str));
        br.close();
    }
}