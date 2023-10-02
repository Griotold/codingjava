package kim.ch3_twopointers_slidingwindows;

public class 최대길이연속부분수열_6 {
    public int solution(int N, int M, int[] arr) {
        int answer = 0, cnt = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < N; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > M) {
                if(arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            sum = rt - lt + 1;
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
