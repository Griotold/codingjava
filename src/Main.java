import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void dfs(int idx) {
        if (idx > 7) {
            return;
        } else {
            System.out.print(idx + " ");
            dfs(idx * 2);
            dfs(idx * 2 + 1);
        }

    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 재귀함수 호출
        dfs(1);

        br.close();
        bw.close();
    }
}