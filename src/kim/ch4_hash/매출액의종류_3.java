package kim.ch4_hash;

import java.util.ArrayList;
import java.util.HashMap;

public class 매출액의종류_3 {
    /**
     * 올바른 풀이 - Hash, Two Pointers, Sliding Window
     * */
    public ArrayList<Integer> sol3(int n, int k, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        // 다음 반복 수행 전에 먼저 맨 앞 요소를 빼버린다.
        for(int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) - 1);
            if(HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
    // 내풀이 - 힌트 듣고 풂 - Sliding Window 문제들 처럼 풂
    public ArrayList<Integer> sol2(int N, int K, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < K - 1; i++) {
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int lt = 0;
        for(int rt = K - 1; rt < N; rt++) {
            int num = arr[rt];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while(rt - lt >= K) {
                int num2 = arr[lt];
                if(map.get(num2) == 1) map.remove(num2);
                else map.put(num2, map.get(num2) - 1);
                lt++;
            }
            answer.add(map.size());
        }
        return answer;
    }
    // 내풀이 - 타임초과
    public ArrayList<Integer> solution(int N, int K, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N - K + 1; i++) {
            int cnt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < K + i; j++) {
                int num = arr[j];
                if(!map.containsKey(num)) {
                    map.put(num, 1);
                    cnt++;
                }
            }
            answer.add(cnt);
        }
        return answer;
    }
}
