import java.io.*;
import java.util.*;
public class Main {
    // 6
    // 13 5 11 7 23 15 --> 5 7 11 13 15 23
    public int[] sol(int N, int[] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // swap
//            int temp = arr[i];
//            arr[i] = arr[idx];
//            arr[idx] = temp;
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