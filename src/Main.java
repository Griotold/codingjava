import java.io.*;
import java.util.*;
public class Main {
    /**
     * 문자열
     * 첫글자와 마지막 글자 출력
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int len = str.length();
            String answer = "";
            answer += str.charAt(0);
            answer += str.charAt(len - 1);

            bw.write(answer);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}