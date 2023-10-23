package kim.ch9_greedy.data;

public class Wedding implements Comparable<Wedding>{
    public int time;
    public String state;

    public Wedding(int t, String s) {
        time = t;
        state = s;
    }

    @Override
    public int compareTo(Wedding o) {
        if(this.time == o.time) return this.state.compareTo(o.state);
        return this.time - o.time;
    }
}
