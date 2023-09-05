import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void dfs(int idx) {
        if (idx == 1) {
            System.out.print(idx);
        } else {
            dfs(idx / 2);
            System.out.print(idx % 2);
        }

    }

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        // 재귀함수 호출
        dfs(N);

        br.close();
        bw.close();
    }
}