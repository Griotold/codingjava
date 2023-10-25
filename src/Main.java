import kim.ch10_dp.data.Brick;

import java.io.*;
import java.util.*;
public class Main {
    // 5
    //25 3 4
    //4 4 6
    //9 2 3
    //16 2 5
    //1 5 2   --> 10
    static int N;
    static int[] dp;
    static ArrayList<Brick> arr;
    public int sol() {
        int answer = 0;
        Collections.sort(arr);
        dp[0] = arr.get(0).height;
        answer = dp[0];
        for(int i = 1; i < N; i++) {
            int max = 0;
            Brick now = arr.get(i);
            for (int j = i - 1; j >= 0; j--) {
                Brick tmp = arr.get(j);
                if(tmp.weight > now.weight && dp[j] > max) max = dp[j];
            }
            dp[i] = max + now.height;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Brick(area, height, weight));
        }
        System.out.println(T.sol());
        br.close();
    }
}