package kim.ch6_sort_binary_search_decision;

import java.util.Arrays;

public class 이분검색_8 {
    public int sol(int N, int M, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = N - 1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == M) {
                answer = mid + 1;
                break;
            }
            else if (arr[mid] > M) rt = mid - 1;
            else lt = mid + 1;
        }
        return answer;
    }
}
