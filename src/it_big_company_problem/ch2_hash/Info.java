package it_big_company_problem.ch2_hash;

public class Info implements Comparable<Info>{
    public String name;
    public int time;

    public Info(String name, int time) {
        this.name = name;
        this.time = time;
    }
    @Override
    public int compareTo(Info ob) {
        return this.time - ob.time;
    }
}
