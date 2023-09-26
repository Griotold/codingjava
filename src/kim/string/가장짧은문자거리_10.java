package kim.string;

public class 가장짧은문자거리_10 {
    public int[] solution(String str, char t) {
        int len = str.length();
        int[] answer = new int[len];
        int p = 1000;
        // 1. 왼쪽 for문
        for(int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if(ch == t) {
                p = 0;
                answer[i] = p;
            } else {
                answer[i] = p;
            }
            p++;
        }
        p = 1000;
        // 2. 오른쪽 for문
        for(int i = len - 1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == t){
                p = 0;
                answer[i] = p;
            } else {
                answer[i] = Math.min(answer[i], p);
            }
            p++;
        }
        return answer;
    }
}
