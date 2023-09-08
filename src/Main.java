import java.util.*;
public class Main {

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 비교
        int i;
        for(i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                break;
        }

        // 3. 발견 못하면 마지막 놈이 완주 못한 것임
        // 4. 리턴
        return participant[i];
    }
    public static void main(String[] args)  {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};

        System.out.println(solution(part, comp));
    }
}