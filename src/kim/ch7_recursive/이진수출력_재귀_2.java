package kim.ch7_recursive;
/**
 * 재귀를 활용해 이진수 출력
 * */
public class 이진수출력_재귀_2 {
    /**
     * 다른 풀이 - 좀 더 직관적이다
     */
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS(n / 2);
            System.out.println(n % 2);
        }
    }
    /**
     * 내 풀이
     * */
    public void sol(int N) {
        if(N == 1) {
            System.out.print(N);
//            return;
        } else {
            int rest = N % 2; // 나머지
            int quotient = N / 2; // 몫
            sol(quotient);
            System.out.print(rest);
        }
    }
}
