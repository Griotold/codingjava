import java.io.*;
import java.util.*;
public class Main {
    // 5 2
    // 60 50 70 80 90 --> 3
    public int sol(int N, int M, int[] arr) {
        int answer = 1;
        List<Person> queue = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            queue.add(new Person(i, arr[i]));
        }
        while(true) {
            Person now = queue.remove(0);
            boolean boom = true;
            for(int i = 0; i < queue.size(); i++){
                Person rest = queue.get(i);
                if(now.ratio < rest.ratio) {
                    queue.add(now);
                    boom = false;
                    break;
                }
            }
            if(boom) {
                if(M == now.order) break;
                else answer++;
            }
        }

        return answer;
    }
    class Person {
        int order;
        int ratio;
        public Person(int order, int ratio) {
            this.order = order;
            this.ratio = ratio;
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.sol(N, M, arr));
        br.close();
    }
}