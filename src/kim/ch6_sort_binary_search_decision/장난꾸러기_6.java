package kim.ch6_sort_binary_search_decision;

import java.util.ArrayList;
import java.util.Arrays;

public class 장난꾸러기_6 {
    /**
     * 강사님 풀이
     * */
    public ArrayList<Integer> solByTeacher(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1. 깊은 복사
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) answer.add(i + 1);
        }
        return answer;
    }

    /**
     * 내 풀이 - 오답
     * */
    public int[] sol(int N, int[] arr) {
        int[] answer = new int[2];
        int i;
        for(i = 0; i < N - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                answer[0] = i + 1;
                break;
            }
        }
        for(int j = i + 1; j < N; j++) {
            if(arr[j] < arr[j - 1]) answer[1] = j + 1;
        }
        return answer;
    }
}
