package baekjoon.DFS.recur;
/**
 * 이진트리 baekjoon.DFS 전위순회, 중위 순회, 후위순회
 * */
public class RecurEx3_58 {
    /**
     * 전위 순회 1 2 4 5 3 6 7
     * */
    public static void front(int idx){
        if (idx > 7) {
            return;
        } else {
            System.out.print(idx + " ");
            front(idx * 2);
            front(idx * 2 + 1);
        }
    }
    /**
     * 중위 순회 4 2 5 1 6 3 7
     * */
    public static void middle(int idx) {
        if (idx > 7) {
            return;
        } else {
            middle(idx * 2);
            System.out.print(idx + " ");
            middle(idx * 2 + 1);
        }
    }
    /***
     *
     * 후위 순회 4 5 2 6 7 3 1
     */
    public static void back(int idx) {
        if (idx > 7) {
            return;
        } else {
            back(idx * 2);
            back(idx * 2 + 1);
            System.out.print(idx + " ");
        }
    }
}
