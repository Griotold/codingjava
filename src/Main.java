import java.io.*;
import java.util.*;
public class Main {
    public int solution(String str) {
        int answer = 0;
        String temp = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                temp += ch;
            }
        }
        answer = Integer.parseInt(temp);
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