import java.io.*;
import java.util.*;
public class Main {
    // 7 4
    // 20 12 20 10 23 17 10
    public ArrayList<Integer> solution(int N, int K, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < K - 1; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int lt = 0;
        for(int rt = K - 1; rt < N; rt++) {
            int num = arr[rt];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while(rt - lt >= K) {
                int num2 = arr[lt];
                if(map.get(num2) == 1) map.remove(num2);
                else map.put(num2, map.get(num2) - 1);
                lt++;
            }
            answer.add(map.size());
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int x : T.solution(N, K, arr)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}