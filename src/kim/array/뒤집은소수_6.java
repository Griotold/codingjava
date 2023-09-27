package kim.array;

import java.util.ArrayList;

public class 뒤집은소수_6 {
    /**
     * 소수 판별을 메소드로 뽑은 방식
     * */
    public boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++){
            int tmp=arr[i];
            int res=0;
            while(tmp>0){
                int t=tmp%10;
                res=res*10+t;
                tmp=tmp/10;
            }
            if(isPrime(res)) answer.add(res);
        }
        return answer;
    }
    /**
     * 내 풀이
     * */
    public ArrayList<Integer> solution2(int N, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int tmp = arr[i];
            int reversed = 0;
            boolean flag = false;
            while(tmp > 0) {
                int remain = tmp % 10;
                tmp /= 10;
                reversed = reversed * 10 + remain;
            }
            for(int j = 2; j * j <= reversed; j++) {
                if(reversed % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag && reversed != 1) {
                answer.add(reversed);
            }
        }

        return answer;
    }
}
