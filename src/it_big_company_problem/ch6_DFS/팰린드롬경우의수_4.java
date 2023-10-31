package it_big_company_problem.ch6_DFS;

import java.util.*;
/**
 * Deque 자료구조
 * */
public class 팰린드롬경우의수_4 {
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> map;
    int len;

    public void DFS() {
        if (tmp.size() == len) {
            String ts = "";
            for(char x : tmp) ts += x;
            res.add(ts);
        } else {
            for (char key : map.keySet()) {
                if(map.get(key) == 0) continue;
                tmp.addFirst(key);
                tmp.addLast(key);
                map.put(key, map.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                map.put(key, map.get(key) + 2);
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        map = new HashMap<>();
        len = s.length();

        // 1. 팰린드롬을 만들 수 있는지 없는지 판별
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int odd = 0;
        char mid = '#';
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                mid = key;
                odd++;
            }
        }
        if(odd > 1) return new String[]{};
        if(mid != '#') {
            tmp.add(mid);
            map.put(mid, map.get(mid) - 1);
        }

        // 2. DFS 호출
        DFS();
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);

        return answer;
    }

    public static void main(String[] args){
        팰린드롬경우의수_4 T = new 팰린드롬경우의수_4();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
