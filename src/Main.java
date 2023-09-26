import java.io.*;
import java.util.*;
public class Main {
    public String solution(String str, int N) {
        String answer = "";
        for(int i = 0; i < N; i++) {
            String tmp = str.substring(0, 7)
                    .replace("#", "1")
                    .replace("*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(T.solution(str, N));
        br.close();
    }
}