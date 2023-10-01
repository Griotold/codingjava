package kim.ch3_twopointers_slidingwindows;

public class 최대매출_3 {
    public int solution(int N, int K, int[] arr) {
        int answer = 0, sum = 0;
        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i = K; i < N; i++){
            sum += arr[i];
            sum -= arr[i - K];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
