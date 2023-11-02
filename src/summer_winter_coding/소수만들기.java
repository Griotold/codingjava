package summer_winter_coding;

public class 소수만들기 {
    int count;
    int[] combi;
    public boolean isPrime(int num) {
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public void DFS(int L, int s, int[] nums) {
        if(L == 3) {
            int sum = 0;
            for(int i = 0; i < 3; i++) {
                sum += nums[combi[i]];
            }
            if(isPrime(sum)) count++;
        } else {
            for(int i = s; i < nums.length; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1, nums);
            }
        }
    }

    public int solution(int[] nums) {
        int answer = -1;
        combi = new int[3];
        DFS(0, 0, nums);

        return count;
    }
}
