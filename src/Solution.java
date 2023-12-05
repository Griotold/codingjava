import java.util.*;

class Solution {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Set<Integer> countSet = new HashSet<Integer>();
        for (char key : map.keySet()) {
            while (map.get(key) > 0) {
                if (countSet.contains(map.get(key))) {
                    map.put(key, map.get(key) - 1);
                    answer++;
                } else {
                    countSet.add(map.get(key));
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }

}
