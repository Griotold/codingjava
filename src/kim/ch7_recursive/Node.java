package kim.ch7_recursive;

public class Node {
    public int data;
    public Node lt;
    public Node rt;
    public Node(int data) {
        this.data = data;
        lt=rt=null;
    }
}
