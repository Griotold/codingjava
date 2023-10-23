package kim.ch9_greedy.data;

public class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    // cost를 기준으로 오름차순
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
