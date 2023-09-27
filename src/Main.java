import java.io.*;
import java.util.*;
public class Main {
//    9
//    32 55 62 20 250 370 200 30 100
    public ArrayList<Integer> solution(int N, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            int reversed = 0;
            boolean flag = false;
            while(tmp > 0) {
                int remain = tmp % 10;
                tmp /= 10;
                reversed = reversed * 10 + remain;
            }
            for(int j = 2; j * j <= reversed; j++) {
                if(reversed % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag && reversed != 1) {
                answer.add(reversed);
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
        for(int x: T.solution(N, arr)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}