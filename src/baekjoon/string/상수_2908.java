package baekjoon.string;

import java.io.*;
import java.util.StringTokenizer;

public class 상수_2908 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String lt = st.nextToken();
        String rt = st.nextToken();

        String reverseLt = new StringBuilder(lt).reverse().toString();
        String reverseRt = new StringBuilder(rt).reverse().toString();

        int convertReverseLt = Integer.parseInt(reverseLt);
        int convertReverseRt = Integer.parseInt(reverseRt);

        if (convertReverseLt > convertReverseRt) {
            bw.write(String.valueOf(convertReverseLt));
        } else {
            bw.write(String.valueOf(convertReverseRt));
        }

        br.close();
        bw.close();
    }
}
