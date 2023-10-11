package kim.ch6_sort_binary_search_decision;
/**
 * 결정 알고리즘 = 이분 검색 심화
 * */
public class 뮤직비디오_결정알고리즘_9 {
    /**
     * lt, rt 세팅은 스트림 문법으로 간편하게 할 수도 있다.
     * */
    public int sol(int N, int M, int[] arr) {
        int answer = 0, lt = 0, rt = 0;
        // 1. lt, rt 값 세팅
        for(int x : arr) {
            lt = Math.max(lt, x);
            rt += x;
        }
        // int lt = Arrays.stream(arr).max().getAsInt();
        // int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(isPossible(mid, M, arr)) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
    /**
     * 강사님이 짠 메서드
     * */
    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0; // dvd 장수, 곡들의 합
        for (int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }
    /**
     * 내가 짠 메서드
     * */
    private boolean isPossible(int mid, int M, int[] arr) {
        int count = 0, sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > mid) {
                count++;
                sum = arr[i];
            }
        }
        if(count >= M) return false;
        return true;
    }
}
