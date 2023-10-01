package kim.ch3_twopointers_slidingwindows;

public class 연속부분수열_4 {
    public int solution(int N, int M, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < N; rt++){
            sum += arr[rt];
            if(sum == M) answer++;
            while(sum >= M) {
                sum -= arr[lt++];
                if(sum == M) answer++;
            }
        }
        return answer;
    }
}
