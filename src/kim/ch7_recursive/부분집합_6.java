package kim.ch7_recursive;

public class 부분집합_6 {
    static int n;
    static int[] ch;

    public void DFS(int L) {
        if(L == n + 1) {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else{
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    /**
     * 내 풀이 - 미완
     * */
    public void DFSMine(int N) {
        if(N == 0) return;
        else{
            for(int i = 1; i <= N; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            DFS(N - 1);
        }
    }
    public static void main(String[] args) {
        부분집합_6 T = new 부분집합_6();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
    }
}
