package it_big_company_problem.ch3_data_structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
/**
 * 두 풀이 다 괜찮은 것 같음
 * */
public class 최대길이연속수열_1 {
    /**
     * 내 풀이 : TreeSet 활용
     * */
    public int solution(int[] nums){
        int answer = 0;
        int count = 0;
        // 1. TreeSet에 담기 - 정렬, 중복 제거
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        // 2. 각 요소를 다음 요소와 비교
        ArrayList<Integer> list = new ArrayList<>(treeSet);
        for(int i = 0; i < list.size() - 1; i++) {
            int num = list.get(i);
            int next = list.get(i + 1);
            if(num + 1 == next) count++;
            else count = 0;
            answer = Math.max(answer, count);
        }
        return answer + 1;
    }

    /**
     * 강사님 풀이 : 그냥 Set 활용
     */
    public int solByTeacher(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int x : set) {
            if(set.contains(x - 1)) continue;
            int cnt = 0;
            while (set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        최대길이연속수열_1 T = new 최대길이연속수열_1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
