import java.io.*;
import java.util.*;
public class Main {
    public String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while(lt < rt) {
            if(charArray[lt] != charArray[rt]) {
                answer = "NO";
                break;
            }
            rt--;
            lt++;
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