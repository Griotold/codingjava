import java.io.*;
import java.util.*;


public class Main {
    // 8 32
    // 23 87 65 12 57 32 99 81 -> 3
    public int sol(int N, int M, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = N - 1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == M) {
                answer = mid + 1;
                break;
            }
            else if (arr[mid] > M) rt = mid - 1;
            else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(T.sol(N, M, arr));
        br.close();
    }
}