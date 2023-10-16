package kim.ch7_recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 배열에 저장하는 방식 - 각 노드의 최단거리를 배열에 저장
 * 인접 리스트 활용
 * */
public class 그래프최단거리_배열에저장_14 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int[] dis; // 1번 노드에서 각 노드로 가는 최단 거리

    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        Q.offer(v);
        while (!Q.isEmpty()) {
            int now = Q.poll();
            for (int nv : graph.get(now)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        그래프최단거리_배열에저장_14 T = new 그래프최단거리_배열에저장_14();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        ch = new int[n + 1];
        dis = new int[n + 1];
        for(int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
