package kim.ch3_twopointers_slidingwindows;

public class 연속된자연수의합_5 {
    /**
     * 내 풀이
     * */
    public int solution(int N) {
        int answer = 0, sum = 0, lt = 1;
        for(int rt = 1; rt < N; rt++) {
            sum += rt;
            if(sum == N) answer++;
            while(sum >= N) {
                sum -= lt++;
                if(sum == N) answer++;
            }
        }
        return answer;
    }
    /**
     * 강사님 풀이 : N을 다 돌 필요 없고 N / 2 + 1 까지만
     * */
    public int sol2(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }
        for(int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }
        return answer;
    }
    /**
     * 수학적 방식으로 내풀이
     * */
    public int sol3(int N) {
        int answer = 0, sum;
        for(int i = 2; i < N; i++) {
            sum = 0;
            for(int j = 1; j <= i; j++) {
                sum += j;
            }
            if(N >= sum && (N - sum) % i == 0) answer++;
        }
        return answer;
    }
    /**
     * 수학적 방식으로 강사님 풀이
     * */
    public int sol4(int n) {
        int answer = 0, cnt = 1;
        n--;
        while(n > 0) {
            cnt++;
            n -= cnt;
            if(n % cnt == 0) answer++;
        }
        return answer;
    }
}
