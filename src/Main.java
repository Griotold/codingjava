import java.io.*;
import java.util.*;


public class Main {
    // 9 3
    // 1 2 3 4 5 6 7 8 9 -> 17
    public int sol(int N, int M, int[] arr) {
        int answer = 0, lt = 0, rt = 0;
        // 1. lt, rt 값 세팅
        for(int x : arr) {
            lt = Math.max(lt, x);
            rt += x;
        }
        // int lt = Arrays.stream(arr).max().getAsInt();
        // int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(isPossible(mid, M, arr)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0; // dvd 장수, 곡들의 합
        for (int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    private boolean isPossible(int mid, int M, int[] arr) {
        int count = 0, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > mid) {
                count++;
                sum = arr[i];
            }
        }
        if(count >= M) return false;
        return true;
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