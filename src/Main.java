import java.io.*;
import java.util.*;
public class Main {
    // 5 9
    // 1 2 3 2 6 2 3 5 7 -> 7 5 3 2 6
    public int[] sol(int S, int N, int[] arr) {
        int[] cache = new int[S];
        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            int idx = S - 1;
            // 1. cache miss 인지 hit 인지 판별
            for(int j = 0; j < S; j++) {
                if(cache[j] == tmp) {
                    idx = j;
                }
            }
            for(int j = idx; j >= 1; j--){
                cache[j] = cache[j - 1];
            }
            cache[0] = tmp;
        }
        return cache;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int x : T.sol(S, N, arr)) System.out.print(x + " ");
        br.close();
    }
}