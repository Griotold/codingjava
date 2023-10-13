package kim.ch7_recursive;

public class 팩토리얼_3 {
    public int sol(int N) {
        if(N == 1) {
            return 1;
        } else{
            return N * sol(N - 1);
        }
    }
}
