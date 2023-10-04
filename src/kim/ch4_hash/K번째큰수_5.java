package kim.ch4_hash;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class K번째큰수_5 {
    /**
     * 올바른 풀이 - TreeSet
     * */
    public int sol3(int N, int K, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int s = j + 1; s < N; s++) {
                    set.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }
        int cnt = 0;
        for(int x : set) {
            cnt++;
            if(cnt == K) return x;
        }
        return answer;
    }
    public int sol2() {
        int answer = 0;
        return answer;
    }
    // 이터레이터
    public int sol2(int N, int K, int[] arr) {
        int answer = -1;
        // 내림 차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // 1. N에서 3개를 뽑는 경우의 수
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int s = j + 1; s < N; s++) {
//                    System.out.println(i + " " + j + " " + s);
                    set.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }
//        System.out.println(set);
        // 2. set은 중복을 허용하지 않는다
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < K; i++) {
            answer = iterator.next();
        }
        return answer;
    }
    // 내 풀이
    public int solution(int N, int K, int[] arr) {
        int answer = -1;
        // 내림 차순 정렬
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // 1. N에서 3개를 뽑는 경우의 수
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int s = j + 1; s < N; s++) {
//                    System.out.println(i + " " + j + " " + s);
                    set.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }
//        System.out.println(set);
        // 2. set은 중복을 허용하지 않는다
        int count = 1;
        while(count < K) {
            set.remove(set.first());
            count++;
        }
        answer = set.first();
        return answer;
    }
}
