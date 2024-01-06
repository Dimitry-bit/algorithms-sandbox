/* 1.4.3 Modify DoublingTest to use StdDraw to produce plots like the standard and
log-log plots in the text, rescaling as necessary so that the plot always fills a substantial
portion of the window. */

package prj.algs4.chapter1.section4;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;
import prj.utils.Point;

public final class ThreeSumDoublingVisualize {
    private static final int MAXIMUM_INTEGER = 1000000;

    private final ArrayList<Point> points = new ArrayList<>();
    private int canvasXScale = 1;
    private int canvasYScale = 1;
    private final double scaleThresholdMultiplier = 0.75;

    public double timeTrial(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; ++i) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }

        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        double time = timer.elapsedTime();

        points.add(new Point(n, time));

        return time;
    }

    public void DrawPlot() {
        if (canRescale()) {
            rescale();
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < points.size(); ++i) {
            Point a = points.get(i - 1);
            Point b = points.get(i);
            StdDraw.line(a.x, a.y, b.x, b.y);
        }

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        for (Point p : points) {
            StdDraw.point(p.x, p.y);
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor();
    }

    public void DrawLogLogPlot() {
        if (canRescale()) {
            rescale();
        }

        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 1; i < points.size(); ++i) {
            if (isValidLogPoint(points.get(i - 1)) && isValidLogPoint(points.get(i))) {
                Point a = logPoint(points.get(i - 1));
                Point b = logPoint(points.get(i));
                StdDraw.line(a.x, a.y, b.x, b.y);
            }
        }

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        for (Point p : points) {
            if (isValidLogPoint(p)) {
                Point a = logPoint(p);
                StdDraw.point(a.x, a.y);
            }
        }

        StdDraw.setPenRadius();
        StdDraw.setPenColor();
    }

    private void rescale() {
        Point p = points.getLast();
        while (p.x > canvasXScale * scaleThresholdMultiplier) {
            canvasXScale *= 2;
            StdDraw.setXscale(0, canvasXScale);
        }

        while (p.y > canvasYScale * scaleThresholdMultiplier) {
            canvasYScale *= 2;
            StdDraw.setYscale(0, canvasYScale);
        }
    }

    private boolean canRescale() {
        if (points.isEmpty()) {
            return false;
        }

        Point p = points.getLast();
        return (p.x > canvasXScale * scaleThresholdMultiplier || p.y > canvasYScale * scaleThresholdMultiplier);
    }

    private boolean isValidLogPoint(Point p) {
        return (p.x > 0.0 && p.y > 0.0);
    }

    private Point logPoint(Point p) {
        return new Point(Math.log(p.x), Math.log(p.y));
    }

    public static void main(String[] args) {
        ThreeSumDoublingVisualize threeSum = new ThreeSumDoublingVisualize();
        for (int n = 2; true; n += n) {
            double time = threeSum.timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            StdDraw.clear();
            threeSum.DrawPlot();
            threeSum.DrawLogLogPlot();
        }
    }
}
