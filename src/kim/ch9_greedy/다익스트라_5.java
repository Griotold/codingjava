package kim.ch9_greedy;

import kim.ch9_greedy.data.Edge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라_5 {
    static int N, M;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void sol(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.vex, nowCost+ ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        다익스트라_5 T = new 다익스트라_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
        }
        T.sol(1);
        for (int i = 2; i <= N; i++) {
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
        br.close();
    }
}
