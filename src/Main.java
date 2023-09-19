import java.io.*;
import java.util.*;
public class Main {
    /**
     * 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력
     * 하는 프로그램 작성
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        char ch = s.charAt(i - 1);
        bw.write(ch);

        br.close();
        bw.close();
    }
}