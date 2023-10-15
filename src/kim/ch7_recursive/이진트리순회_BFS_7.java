package kim.ch7_recursive;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리순회_BFS_7 {
    Node root;
    public void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);
        int L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.println("L = " + L);
            for(int i = 0; i < len; i++) {
                Node now = Q.poll();
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
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        T.BFS(T.root);
    }
}

