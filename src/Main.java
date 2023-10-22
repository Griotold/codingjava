
import kim.ch9_greedy.Player;
import java.io.*;
import java.util.*;


public class Main {
    // 5
    //172 67
    //183 65
    //180 70
    //170 72
    //181 60 --> 3
    static int N;
    static ArrayList<Player> list;

    public int sol() {
        int answer = 0;
        for(int i = 0; i < N; i++) {
            Player now = list.get(i);
            boolean flag = true;
            for(int j = 0 ; j < N; j++) {
                if(i == j) continue;
                Player tmp = list.get(j);
                if(now.height < tmp.height && now.weight < tmp.weight) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Player(h, w));
        }
        System.out.println(T.sol());
        br.close();
    }
}