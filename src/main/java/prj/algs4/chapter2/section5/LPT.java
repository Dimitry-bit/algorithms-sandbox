/* 2.5.13 Load balancing. Write a program LPT.java that takes an integer M as a command-line argument,
reads job names and processing times from standard input and prints a schedule assigning the jobs to
M processors that approximately minimizes the time when the last job completes using the longest processing
time first rule, as described on page 349. */

package prj.algs4.chapter2.section5;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.StdIn;

public class LPT {

    public static void main(String[] args) {

        class Processor implements Comparable<Processor> {
            int id;
            int priority;

            Processor(int id) {
                this.id = id;
            }

            void addJob(Job job) {
                priority += job.time;
            }

            @Override
            public int compareTo(Processor o) {
                if (priority < o.priority) {
                    return -1;
                } else if (priority > o.priority) {
                    return 1;
                } else {
                    return 0;
                }
            }

            @Override
            public String toString() {
                return String.valueOf(id);
            }
        }

        System.out.print("# Jobs: ");
        int n = StdIn.readInt();

        System.out.print("# Processors: ");
        int m = StdIn.readInt();

        Job jobs[] = new Job[n];
        PriorityQueue<Processor> processors = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            processors.add(new Processor(i));
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Job Name: ");
            String name = StdIn.readString();
            System.out.printf("Job '%s' time: ", name);
            int time = StdIn.readInt();
            jobs[i] = new Job(name, time);
        }

        Arrays.sort(jobs, Collections.reverseOrder());

        for (Job j : jobs) {
            Processor p = processors.poll();
            p.addJob(j);
            processors.add(p);

            System.out.printf("Job '%s' assigned to processor '%s'.\n", j, p);
        }
    }
}
