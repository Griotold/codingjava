package it_big_company_problem.ch5_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 전투게임_5 {

    private static class Student {
        String team;
        int power;

        Student(String team, int power) {
            this.team = team;
            this.power = power;
        }
    }
    /**
     * 내 코드
     * // todo 효율성 생각하지 않아서 리팩토링 필요
     * */
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        // 1. 리스트
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splited = students[i].split(" ");
            list.add(new Student(splited[0], Integer.valueOf(splited[1])));
        }

        // 2. 반복문
        for (int i = 0; i < n; i++) {
            Student main = list.get(i);
            for (int j = 0; j < n; j++) {
                Student sub = list.get(j);
                if (!main.team.equals(sub.team) && main.power > sub.power) {
                    answer[i] += sub.power;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        전투게임_5 T = new 전투게임_5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
