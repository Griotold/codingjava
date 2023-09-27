import java.io.*;
import java.util.*;
public class Main {
//    8
//            130 135 148 140 145 150 150 153
    public int solution(int N, int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        return  answer;

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, arr));
        br.close();
    }
}