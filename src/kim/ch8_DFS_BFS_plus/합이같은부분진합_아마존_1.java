package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이같은부분진합_아마존_1 {
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
        합이같은부분진합_아마존_1 T = new 합이같은부분진합_아마존_1();
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
