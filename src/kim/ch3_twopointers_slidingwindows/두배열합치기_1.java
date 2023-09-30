package kim.ch3_twopointers_slidingwindows;

import java.util.ArrayList;

public class 두배열합치기_1 {
    /**
     * 내 풀이
     * */
    public int[] solution(int N, int M, int[] arr1, int[] arr2) {
        int[] answer = new int[N + M];
        int lt = 0, rt = 0, index = 0;
        while(true) {
            if(arr1[lt] > arr2[rt]) {
                answer[index++] = arr2[rt++];
            } else if(arr1[lt] < arr2[rt]) {
                answer[index++] = arr1[lt++];
            } else {
                answer[index++] = arr2[rt++];
                answer[index++] = arr1[lt++];
            }
            if(lt == N || rt == M ) break;
        }
        for(int i = lt; i < N; i++) {
            answer[index++] = arr1[i];
        }
        for(int j = rt; j < M; j++) {
            answer[index++] = arr2[j];
        }
        return answer;
    }
    /**
     * 강사님 풀이
     * */
    public ArrayList<Integer> solution2(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < m) answer.add(b[p2++]);
        return answer;
    }
}
