import kim.ch7_recursive.Node;

import java.io.*;
import java.util.*;

public class Main {
    Node root;
    public int DFS(int L, Node node) {
        if (node.lt == null && node.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, node.lt), DFS(L+1, node.rt));
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.DFS(0, T.root));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.close();
    }
}