import java.io.*;
import java.util.*;
public class Main {
    // 8 3 --> 7
    public int solution(int N, int K) {
        int answer = 0, count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while(queue.size() != 1) {
            count++;
            if(count == K) {
                queue.poll();
                count = 0;
            }
            else queue.offer(queue.poll());
        }
        answer = queue.poll();
        return answer;
    }
    public int solByArrayList(int n, int k) {
        int answer = 0;
        List<Integer> queue = new ArrayList<>();
        for(int i = 1; i <= n; i++) queue.add(i);
        while(!queue.isEmpty()) {
            for(int i = 1; i < k; i++) queue.add(queue.remove(0));
            queue.remove(0);
            if(queue.size() == 1) answer = queue.remove(0);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(N, K));
        System.out.println(T.solByArrayList(N, K));
        br.close();
    }
}