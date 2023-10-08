package kim.ch6_sort_binary_search_decision;

public class 선택정렬_1 {
    public int[] sol(int N, int[] arr) {
        for(int i = 0; i < N; i++) { // N - 1 까지 돌아도 되고, N까지 돌아도 된다
            int idx = i;
            for(int j = i + 1; j < N; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

}
