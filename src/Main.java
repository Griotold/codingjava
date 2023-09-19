import java.io.*;
import java.util.*;
public class Main {
    /**
     * 문자열 반복 2675
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            String answer = "";
            for(int i = 0; i < S.length(); i++){
                for(int j = 0; j < R; j++) {
                    answer += S.charAt(i);
                }
            }
            bw.write(answer);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}