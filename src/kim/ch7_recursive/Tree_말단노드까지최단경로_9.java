package kim.ch7_recursive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 최단거리는 BFS로 푸는 것이 맞다
 * */
public class Tree_말단노드까지최단경로_9 {
    /**
     * DFS
     * */
    public int DFS(int L, Node node) {
        if (node.lt == null && node.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, node.lt), DFS(L+1, node.rt));
        }
    }
    /**
     * BFS
     * */
    public int BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                Node now = Q.poll();
                if(now.lt == null && now.rt == null){
                    return L;
                }
                if(now.lt != null) Q.offer(now.lt);
                if(now.rt != null) Q.offer(now.rt);
            }
            L++;
        }
        return 0;
    }
}
