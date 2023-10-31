package it_big_company_problem.ch1_simulation;

import java.util.ArrayList;

/**
 * 네이버, 카카오톡 기출
 * */
public class 최대길이바이토닉수열_5 {
    /**
     * 내 풀이 - 비효율적인 코드
     * */
    public int solution(int[] nums){
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int j;
            for (j = i; j < nums.length - 1; j++) {
                if(nums[j] >= nums[j + 1]) break;
                count++;
            }
            for (int k = j; k < nums.length - 1; k++) {
                if(nums[k] <= nums[k + 1]) break;
                count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    /**
     * 힌트 듣고 다시 푼 코드
     */
    public int solBy2(int[] nums) {
        int answer = 0;
        // 1. 봉우리 지점 먼저 찾기
        ArrayList<Integer> peaks = new ArrayList<>();
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                peaks.add(i);
            }
        }

        // 2. 봉우리마다 길이 측정
        for(int i = 0; i < peaks.size(); i++) {
            int count = 1;
            int peakIndex = peaks.get(i);
            while(peakIndex > 0) {
                if (nums[peakIndex - 1] > nums[peakIndex]) break;
                peakIndex--;
                count++;
            }
            int peakIndex2 = peaks.get(i);
            while(peakIndex2 < nums.length - 1) {
                if(nums[peakIndex2 + 1] > nums[peakIndex2]) break;
                peakIndex2++;
                count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    /**
     * 정답
     */
    public int solByTeacher(int[] nums) {
        int answer = 0;
        int n = nums.length;
        // 1. 봉우리 먼저 찾기
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }
        // 2. 봉우리마다 길이 측정
        for (int x : peaks) {
            int left = x;
            int right = x;
            int cnt = 1;
            while (left - 1 >= 0 && nums[left - 1] < nums[left]) {
                left--;
                cnt++;
            }
            while(right + 1 < n && nums[right] > nums[right+1]) {
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        최대길이바이토닉수열_5 T = new 최대길이바이토닉수열_5();
        System.out.println(T.solByTeacher(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solByTeacher(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solByTeacher(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solByTeacher(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
