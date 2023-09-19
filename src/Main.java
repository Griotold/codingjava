import java.io.*;
import java.util.*;
public class Main {
    /**
     * 상수 2908
     * */
    public static void main(String[] args) throws IOException {
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