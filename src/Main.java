import java.io.*;
import java.util.*;

public class Main {
    // 6
    // 1 3 5 6 7 10
    static String answer = "NO";
    static int N, total;
    static boolean flag = false;
    static int[] arr;
    public void DFS(int L, int sum) {
        if(flag) return;
        if(sum > total / 2) return;
        if(L == N) {
            if((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            total += a;
        }
        T.DFS(0, 0);
        System.out.println(answer);
        br.close();
    }
}