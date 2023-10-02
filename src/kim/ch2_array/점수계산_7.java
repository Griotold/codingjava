package kim.ch2_array;

public class 점수계산_7 {
    public int solution(int N, int[] arr) {
        int answer = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            int result = arr[i];
            if(result == 1) {
                answer += 1 + count;
                count++;
            } else {
                count = 0;
            }
        }
        return answer;
    }
}
