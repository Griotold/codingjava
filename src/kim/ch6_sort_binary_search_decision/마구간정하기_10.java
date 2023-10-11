package kim.ch6_sort_binary_search_decision;

import java.util.Arrays;

public class 마구간정하기_10 {

    public int sol(int N, int C, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[N - 1];
        while(lt<=rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }
    public int count(int[] arr, int dist) {
        int ep = arr[0], cnt = 1;
        for(int x : arr) {
            if(x - ep >= dist) {
                cnt++;
                ep = x;
            }
        }
        return cnt;
    }
}
