import java.io.*;
import java.util.*;
public class Main {
    // 9
    // 120 125 152 130 135 135 143 127 160 --> 3 8
    public int[] sol(int N, int[] arr) {
        int[] answer = new int[2];
        int i;
        for(i = 0; i < N - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                answer[0] = i + 1;
                break;
            }
        }
        for(int j = i + 1; j < N; j++) {
            if(arr[j] < arr[j - 1]) answer[1] = j + 1;
        }
        return answer;
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