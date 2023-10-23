package kim.ch9_greedy.data;

public class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    public Lecture(int m, int t) {
        money = m;
        time = t;
    }
    // 시간을 기준으로 내림차순
    @Override
    public int compareTo(Lecture o) {
        return (this.time - o.time) * -1;
    }
}
