import java.io.*;
import java.util.*;
public class Main {
    /**
     * 단어 길이 재기
     * 길이 출력
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        bw.write(String.valueOf(s.length()));
        br.close();
        bw.close();
    }
}