package kim.ch2_array;

public class 보이는학생_2 {
    public int solution(int N, int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        return  answer;

    }
}
