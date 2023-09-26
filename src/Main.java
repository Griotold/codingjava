import java.io.*;
import java.util.*;
public class Main {
    public int[] solution(String str, char t) {
        int len = str.length();
        int[] answer = new int[len];
        int p = 1000;
        // 1. 왼쪽 for문
        for(int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if(ch == t) {
                p = 0;
                answer[i] = p;
            } else {
                answer[i] = p;
            }
            p++;
        }
        p = 1000;
        // 2. 오른쪽 for문
        for(int i = len - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == t){
                p = 0;
                answer[i] = p;
            } else {
                if(answer[i] > p) {
                    answer[i] = p;
                }
            }
            p++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char t = st.nextToken().charAt(0);
        int[] answer = T.solution(str, t);
        for(int x : answer) {
            System.out.print(x + " ");
        }

        br.close();
    }
}