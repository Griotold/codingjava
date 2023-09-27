import java.io.*;
import java.util.*;
public class Main {
    public ArrayList<Integer> solution(int N, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i - 1])
                answer.add(arr[i]);
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
        for (int x : T.solution(N, arr)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}