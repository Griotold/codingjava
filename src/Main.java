import java.io.*;
import java.util.*;
public class Main {
    /**
     * 그대로 출력하기 11718
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";

        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}