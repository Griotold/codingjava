package kim.array;

import java.util.ArrayList;

public class 큰수출력하기_1 {
    public ArrayList<Integer> solution(int N, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i = 1; i < N; i++){
            if(arr[i] > arr[i - 1])
                answer.add(arr[i]);
        }
        return  answer;

    }
}
