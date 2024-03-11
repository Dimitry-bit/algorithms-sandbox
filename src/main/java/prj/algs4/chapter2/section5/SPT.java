/* 2.5.12 Scheduling. Write a program SPT.java that reads job names and processing
times from standard input and prints a schedule that minimizes average completion
time using the shortest processing time first rule, as described on page 349. */

package prj.algs4.chapter2.section5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class SPT {

    public static void main(String[] args) {
        System.out.print("# Jobs: ");
        int n = StdIn.readInt();
        Job jobs[] = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Job Name: ");
            String name = StdIn.readString();
            System.out.printf("Job '%s' time: ", name);
            int time = StdIn.readInt();
            jobs[i] = new Job(name, time);
        }

        Arrays.sort(jobs);

        for (Job job : jobs) {
            System.out.printf("Job '%s'.\n", job);
        }
    }
}
