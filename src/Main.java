import java.io.*;
import java.util.*;


public class Main {
    // 5 3
    // 1 2 8 4 9 --> 3
    public int sol(int N, int C, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[N - 1];
        while(lt<=rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }
    public int count(int[] arr, int dist) {
        int ep = arr[0], cnt = 1;
        for(int x : arr) {
            if(x - ep >= dist) {
                cnt++;
                ep = x;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(T.sol(N, C, arr));
        br.close();
    }
}