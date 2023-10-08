package kim.ch6_sort_binary_search_decision;

public class 삽입정렬_3 {

    public int[] sol(int N, int[] arr) {
        for (int i = 1; i < N; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
