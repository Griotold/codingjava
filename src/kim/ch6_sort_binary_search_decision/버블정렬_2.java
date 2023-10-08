package kim.ch6_sort_binary_search_decision;

public class 버블정렬_2 {
    /**
     * 강사님 풀이
     * */
    public int[] solByTeacher(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    /**
     * 내 풀이
     * */
    public int[] sol(int N, int[] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
