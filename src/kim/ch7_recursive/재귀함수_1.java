package kim.ch7_recursive;

public class 재귀함수_1 {
    /**
     * 다른 풀이
     */
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
    /**
     * 내 풀이
     * */
    public void sol(int N) {
        if(N == 1) {
            System.out.print(N + " ");
            return;
        } else {
            sol(N - 1);
            System.out.print(N + " ");
        }
    }
}
