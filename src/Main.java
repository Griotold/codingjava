import java.io.*;
import java.util.*;

public class Main {
    // 3 2
    // 3 6 9
    static int N, M;
    static int[] arr;
    static int[] answer;
    static int[] ch;

    public void DFS(int L) {
        if(L == M) {
            for(int x : answer) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 0; i < N; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        answer = new int[M];
        ch = new int[M + 1];
        for(int i = 0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        T.DFS(0);

        br.close();
    }
}