package kim.string;

public class 회문_7 {
    /**
     * 1. lt,rt로 풀기
     * */
    public String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while(lt < rt) {
            if(charArray[lt] != charArray[rt]) {
                answer = "NO";
                break;
            }
            rt--;
            lt++;
        }
        return answer;
    }
    /**
     * 2. 반복문에서 length()/2 만큼만 돌며 검증
     * */
    public String solution2(String str){
        String answer = "YES";
        str = str.toLowerCase();
        int len = str.length();
        for(int i = 0; i < len/2; i++) {
            if(str.charAt(i)!= str.charAt(len-i-1)) return "NO";
        }
        return answer;
    }
    /**
     * 3. StringBuilder
     * */
    public String solution3(String str) {
        String answer = "NO";
        StringBuilder stringBuilder = new StringBuilder(str);
        String reversed = stringBuilder.reverse().toString();
        if (str.equalsIgnoreCase(reversed)) answer = "YES";
        return answer;
    }
}
