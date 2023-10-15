package kim.ch7_recursive;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회_BFS_7 {
    Node2 root;
    public void BFS(Node2 node) {
        Queue<Node2> Q = new LinkedList<>();
        Q.offer(node);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.println("L = " + L);
            for(int i = 0; i < len; i++) {
                Node2 now = Q.poll();
                System.out.print(now.data+ " ");
                if(now.lt != null) Q.offer(now.lt);
                if(now.rt != null) Q.offer(now.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        이진트리순회_BFS_7 T = new 이진트리순회_BFS_7();
        T.root = new Node2(1);
        T.root.lt = new Node2(2);
        T.root.rt = new Node2(3);
        T.root.lt.lt = new Node2(4);
        T.root.lt.rt = new Node2(5);
        T.root.rt.lt = new Node2(6);
        T.root.rt.rt = new Node2(7);
        T.BFS(T.root);
    }
}
class Node2 {
    int data;
    Node2 lt;
    Node2 rt;

    public Node2(int data) {
        this.data = data;
        lt=rt=null;
    }
}
