import kim.ch7_recursive.Node;

import java.io.*;
import java.util.*;

public class Main {
    Node root;
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
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.close();
    }
}