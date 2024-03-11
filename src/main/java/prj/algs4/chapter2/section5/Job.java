package prj.algs4.chapter2.section5;

public class Job implements Comparable<Job> {

    final String name;
    final int time;

    public Job(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(Job o) {
        if (time < o.time) {
            return -1;
        } else if (time > o.time) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
