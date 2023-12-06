package it_big_company_problem.ch2_hash;

import java.util.*;

public class 회장선거_5 {
    /**
     * 정답
     */
    public String solByTeacher(String[] votes, int k) {
        String answer = "";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        // 1. 투표 결과와 후보자 기록
        for (String x : votes) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }

        // 2. present 해싱 및 최대값 구하기
        int max = Integer.MIN_VALUE;
        for (String a : voteHash.keySet()) {
            int cnt = 0;
            for (String b : voteHash.get(a)) {
                if (candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        // 3. 가장 많이 받은 사람 리스트에 담기
        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) == max) {
                tmp.add(name);
            }
        }
        // 4. 정렬 후 맨 앞 요소 리턴
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);

        return answer;
    }

    /**
     * 내 풀이
     * */
    public String solution(String[] votes, int k){
        String answer = " ";
        // 1. voteHash -> <String, Set<String>> : 추천한 결과
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String s : votes) {
            String voter = s.substring(0, s.indexOf(' '));
            String target = s.substring(s.indexOf(' ') + 1);
//            System.out.println("voter = " + voter + " target = " + target);
            if (voteHash.get(voter) == null) {
                voteHash.put(voter, new HashSet<>());
            }
            voteHash.get(voter).add(target);

            // 2. candidate -> <String, Integer> : 후보자 리스트
            candidate.put(target, candidate.getOrDefault(target, 0) + 1);

        }

        // 3. present -> <String, Integer> : 선물받은 횟수
        for (String voter : voteHash.keySet()) {
            for(String target : voteHash.get(voter)) {
                if(candidate.get(target) >= k) {
                    present.put(voter, present.getOrDefault(voter, 0) + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        // 4. 선물이 max로 받는 사람 찾기
        for (String voter : present.keySet()) {
            int value = present.get(voter);
            max = Math.max(max, value);
        }
        List<String> result = new ArrayList<>();
        for (String voter : present.keySet()) {
            if(present.get(voter) == max) {
                result.add(voter);
            }
        }

        // 5. 정렬
        Collections.sort(result);
        answer = result.get(0);
        return answer;
    }

    public static void main(String[] args){
        회장선거_5 T = new 회장선거_5();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
