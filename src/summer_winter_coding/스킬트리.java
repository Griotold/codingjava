package summer_winter_coding;
import java.util.*;

public class 스킬트리 {
    /**
     * 내 풀이 - Queue를 계속 생성해야해서 별로인 것 같다.
     * */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        // 1. skill 큐에 넣기
        for(char ch : skill.toCharArray()) queue.offer(ch);

        // 2. skill_trees의 모든 요소가 가능한 스킬 트리인지 조사
        boolean flag;
        for(String str : skill_trees) {
            flag = true;
            queue = new LinkedList<>();
            for(char ch : skill.toCharArray()) queue.offer(ch);
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(queue.contains(ch)) {
                    if(ch != queue.poll()) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
    /**
     * 정규 표현식을 활용
     * */
    public int solByAnother(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]","");
            boolean flag = false;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if(skill.charAt(j) != skill_trees[i].charAt(j)){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        스킬트리 T = new 스킬트리();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
