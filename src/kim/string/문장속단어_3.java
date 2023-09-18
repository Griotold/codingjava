package kim.string;

public class 문장속단어_3 {

    public String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos=str.indexOf(' '))!= -1) {
            String temp = str.substring(0, pos);
            int len = temp.length();
            if (len > m) {
                m = len;
                answer = temp;
            }
            str = str.substring(pos+1);
        }
        return answer;
    }
}
