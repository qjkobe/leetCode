package Review;

import java.util.*;

public class article {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        List<Interval> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String a = in.nextLine();
            String[] strs = a.split(";");
            for (String x : strs) {
                String[] nums = x.split(",");//每个数组
                Interval intervals = new Interval(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
                list.add(intervals);
            }
        }
        List<Interval> res = merge(list);
        for(int i = 0;i<res.size() - 1;i++) {
            System.out.print(res.get(i).start+","+res.get(i).end);
            System.out.print(";");
        }
        System.out.print(res.get(res.size() - 1).start+","+res.get(res.size() - 1).end);

    }
}
