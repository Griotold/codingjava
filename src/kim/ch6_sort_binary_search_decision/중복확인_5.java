package kim.ch6_sort_binary_search_decision;

import java.util.HashMap;
import java.util.TreeSet;

public class 중복확인_5 {
    /**
     * 다른 풀이 - 정렬 후 이웃한 것 끼리 비교해서 다르면 중복
     * */
    public String sol3(int N, int[] arr) {
        // 1. 정렬 -- 삽입 정렬 -> Arrays.sort(arr) api 활용해도 좋음
        for(int i = 1; i < N; i++) {
            int tmp = arr[i], j;
            for (j = i - 1; j >= 0; j--) {
                if(tmp < arr[j]) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        // 2. 이웃한 것 끼리 비교
        for(int i = 0; i < N - 1; i++) {
            if(arr[i] == arr[i + 1]) return "D";
        }
        return "U";
    }

    /**
     * 다른 풀이 - HashMap 활용
     */
    public String solByHashMap(int N, int[] arr) {
        String answer = "U";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            if (map.containsKey(x)) return "D";
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return answer;
    }
    /**
     * 내 풀이 - TreeSet 활용
     * */
    public String sol(int N, int[] arr) {
        // 1. TreeSet에 넣고
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) set.add(x);
        // 크기가 배열보다 작으면 D
        if (set.size() == arr.length) return "U";
        else return "D";
    }
}
