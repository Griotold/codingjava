package kim.ch7_recursive;
class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
public class 이진트리순회_5 {
    /**
     * 전위 순회 - 부모부터 방문
     * */
    public void DFS(Node root) {
        if(root == null) return;
        else{
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
    /**
     * 중위 순회 - 부모를 중간에 방문
     *          : 왼쪽 - 부모 - 오른쪽 순
     * */
    public void DFS2(Node root) {
        if(root == null) return;
        else{
            DFS2(root.lt);
            System.out.print(root.data + " ");
            DFS2(root.rt);
        }
    }
    /**
     * 후위 순회 - 부모를 맨 마지막에 방문
     *          : 왼쪽 - 오른쪽 - 부모순
     * */
    public void DFS3(Node root) {
        if(root == null) return;
        else{
            DFS3(root.lt);
            DFS3(root.rt);
            System.out.print(root.data + " ");
        }
    }
}
