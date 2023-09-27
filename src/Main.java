import java.io.*;
import java.util.*;
public class Main {
//    5
//    87 89 92 100 76
    public int[] solution(int N, int[] arr) {
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N; j++) {
                if(arr[j] > arr[i]) count++;
            }
            answer[i] = count;
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
        for(int x : T.solution(N, arr)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}