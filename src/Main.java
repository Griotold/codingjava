import java.io.*;
import java.util.*;
public class Main {
    // 9 3
    // 1 2 3 4 5 6 7 8 9 --> 17
    public int sol(int N, int M, int[] arr) {
        int answer = 0;
        int rt = Arrays.stream(arr).sum();
        int lt = Arrays.stream(arr).max().getAsInt();
        while(lt<=rt) {
            int mid = (lt + rt) / 2;
            if(count(mid, arr) <= M) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return answer;
    }

    private int count(int size, int[] arr) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > size) {
                cnt++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(T.sol(N, M, arr));

        br.close();
    }
}