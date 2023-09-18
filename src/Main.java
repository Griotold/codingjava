import java.io.*;
import java.util.*;
public class Main {
    /**
     * 6. 중복문자제거
     * ksekkset → kset
     * */
    public String solution(String str) {
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean flag = false;
            for(int j = 0; j < i; j++){
                if(c == str.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer += c;
        }

        // 리턴
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main T = new Main();
        String str = br.readLine();
        System.out.println(T.solution(str));
        br.close();
        bw.close();
    }
}