package kim.array;

public class 등수구하기_8 {
    public int[] solution(int N, int[] arr) {
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            int count = 1;
            for(int j = 0; j < N; j++) {
                if(arr[j] > arr[i]) count++;
            }
            answer[i] = count;
        }
        return answer;
    }
}
