package kim.ch7_recursive;

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
}
