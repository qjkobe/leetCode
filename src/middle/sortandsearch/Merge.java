package middle.sortandsearch;

import java.util.*;

//合并区间
public class Merge {
    public static void main(String[] args) {

    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start,b.start);
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else if (merged.getLast().end >= interval.start) {
                Interval a = new Interval(merged.getLast().start, Math.max(interval.end, merged.getLast().end));
                merged.removeLast();
                merged.add(a);
            }
        }
        return merged;
    }
}
