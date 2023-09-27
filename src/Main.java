import java.io.*;
import java.util.*;
public class Main {
//    10
//    1 0 1 1 1 0 0 1 1 0
    public int solution(int N, int[] arr) {
        int answer = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            int result = arr[i];
            if(result == 1) {
                answer += 1 + count;
                count++;
            } else {
                count = 0;
            }
        }
        return answer;
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