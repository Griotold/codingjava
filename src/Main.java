import java.io.*;
import java.util.*;
public class Main {
    /**
     * 단어의 개수 1152
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());

        br.close();
        bw.close();
    }
}