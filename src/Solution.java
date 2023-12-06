import java.util.*;

class Solution {
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
        Solution T = new Solution();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
