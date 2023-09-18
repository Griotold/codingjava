import java.io.*;
import java.util.*;
public class Main {
    /**
     * 3. 문장 속 단어
     * 주어진 문장 속에서 가장 긴 단어 찾기
     * 여러 개라면 가장 앞에 나온 거 반환
     * */
//    public String solution(String str) {
//        String answer = "";
//        // 1.
////        st = new StringTokenizer()
//
//        return answer;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        String answer = "";
        int max = 0;
        while(st.hasMoreElements()) {
            // 1. 토큰 쪼개기
            String temp = st.nextToken();
            int size = temp.length();

            // 2. 가장 긴 단어 찾기
            if(size > max) {
                max = size;
                answer = temp;
            }
        }

        // answer 출력
        System.out.println(answer);
//        Main main = new Main();
//        System.out.println(main.solution(str));
        br.close();
        bw.close();
    }
}