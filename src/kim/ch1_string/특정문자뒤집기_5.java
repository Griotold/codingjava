package kim.ch1_string;

public class 특정문자뒤집기_5 {
    /**
     * 5. 특정 문자 뒤집기
     * 영어는 뒤집고 특수문자는 자기 자리 그대로
     * a#b!GE*T@S -> S#T!EGb@a
     * */
    public String solution(String str) {
        char[] answer = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while(lt < rt){
            if (!Character.isAlphabetic(answer[lt])){
                // 왼쪽 애가 특수 문자일 때
                lt++;
            } else if(!Character.isAlphabetic(answer[rt])) {
                // 오른쪽 애가 특수 문자일 때
                rt--;
            } else {
                // 둘다 알파벳일 때
                char temp = answer[lt];
                answer[lt] = answer[rt];
                answer[rt] = temp;
                lt++;
                rt--;
            }
        }
//        String answerStr = answer.toString();
        String answerStr = String.valueOf(answer);
        return new String(answer);
    }
}
