package kim.ch9_greedy.data;

public class City implements Comparable<City> {
    public int v1;
    public int v2;
    public int cost;

    // cost를 기준으로 오름차순
    public City(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}
