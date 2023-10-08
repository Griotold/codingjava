import java.io.*;
import java.util.*;
public class Main {
    // 6
    // 13 5 11 7 23 15 --> 5 7 11 13 15 23
    public int[] sol(int N, int[] arr) {
        for (int i = 1; i < N; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int x : T.sol(N, arr)) System.out.print(x + " ");
        br.close();
    }
}