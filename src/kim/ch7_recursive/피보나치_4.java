package kim.ch7_recursive;

public class 피보나치_4 {
    static int[] fibo;
    /**
     * 메모이제이션 - 끝판왕
     * N = 45 일때, 0.xx초 걸림
     * */
    public int DFS3(int N) {
        if(fibo[N] > 0) return fibo[N]; // 기록한 게 있으면 그걸 리턴해라
        if(N == 1) return fibo[N] = 1;
        else if(N == 2) return fibo[N] = 1;
        else return fibo[N] = DFS3(N - 2) + DFS3(N - 1);
    }
    /**
     * 재귀 - 배열에 저장 후 리턴
     * N = 45 일때, 3초 정도 걸림
     * */
    public int DFS2(int N) {
        if(N == 1) return fibo[N] = 1;
        else if(N == 2) return fibo[N] = 1;
        else return fibo[N] = DFS2(N - 2) + DFS2(N - 1);
    }
    /**
     * 재귀로 풀기
     * N = 45 일때, 10초 이상 걸림
     */
    public int DFS(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return DFS(n - 2) + DFS(n - 1);
    }

}
