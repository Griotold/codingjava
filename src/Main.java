import java.io.*;
import java.util.*;
public class Main {
    /**
     * 아스키 코드
     * 말 그대로 아스키 코드 값 출력
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char ch = s.charAt(0);
        int ascii = ch;
        bw.write(String.valueOf(ascii));

        br.close();
        bw.close();
    }
}