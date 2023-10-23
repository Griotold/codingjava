package kim.ch9_greedy.data;

public class Player implements Comparable<Player>{
    public int height;
    public int weight;

    public Player(int h, int w) {
        height = h;
        weight = w;
    }

    /**
     * 내림차순 - 키(신장)를 기준으로
     * */
    @Override
    public int compareTo(Player o) {
        return (this.height - o.height) * -1;
    }
}
