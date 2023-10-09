package kim.ch6_sort_binary_search_decision;

public class LRU_카카오_4 {
    /**
     * 강사님 풀이 -  내 풀이가 나은 것 같다.
     * */
    public int[] solByTeacher(int size, int n, int[] arr){
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) if(x == cache[i]) pos = i;
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
    /**
     * 힌트 듣고 난 후 - 통과
     * */
    public int[] sol2(int S, int N, int[] arr) {
        int[] cache = new int[S];
        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            int idx = S - 1;
            // 1. cache miss 인지 hit 인지 판별
            for(int j = 0; j < S; j++) {
                if(cache[j] == tmp) {
                    idx = j;
                }
            }
            for(int j = idx; j >= 1; j--){
                cache[j] = cache[j - 1];
            }
            cache[0] = tmp;
        }
        return cache;
    }
    /**
     * 내 풀이 - 첫번째 풀이 - 못품
     * */
    public int[] sol(int S, int N, int[] arr) {
        int[] cache = new int[S];
        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            boolean flag = false;
            for(int j = 0; j < S; j++) {
                // cache hit 라면
                int idx = j;
                if(tmp == cache[idx]) {
                    while(idx > 0) {
                        cache[idx] = cache[idx - 1];
                        idx--;
                    }
                    cache[0] = tmp;
                    flag = true;
                }
            }
            // cache miss 라면
            if(!flag) {
                for(int j = 0; j < S - 1; j++) {
                    cache[j + 1] = cache[j];
                }
                cache[0] = tmp;
            }
        }
        return cache;
    }
}
