package kim.ch9_greedy.data;

public class MeetingTime implements Comparable<MeetingTime>{
    public int start;
    public int end;

    public MeetingTime(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int compareTo(MeetingTime o) {
        if(this.end == o.end) return this.start - o.start;
        return this.end - o.end;
    }
}
