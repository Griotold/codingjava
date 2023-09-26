import java.io.*;
import java.util.*;
public class Main {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        answer += str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == str.charAt(i - 1)){
                count++;
            } else {
                if(count != 1) {
                    answer += count;
                }
                answer += ch;
                count = 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str)); // KKHSSSSSSSE
        br.close();
    }
}