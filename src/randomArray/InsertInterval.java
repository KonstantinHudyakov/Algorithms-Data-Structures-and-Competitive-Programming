package randomArray;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list = obj.insert(list, new Interval(6, 8));

        for(Interval x : list) {
            System.out.println(x.start + " " + x.end);
        }
    }

    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int start = findInterval(intervals, newInterval.start);
        int end = findInterval(intervals, newInterval.end);

        if(start == -1 && end == -1) {
            int pos = 0;
            while(pos < intervals.size() && newInterval.start > intervals.get(pos).end)
                pos++;
            intervals.add(pos, newInterval);
        }
        else if(start == -1) {
            start = 0;
            while(start < intervals.size() - 1 && newInterval.start > intervals.get(start).end)
                start++;
            Interval res = new Interval(newInterval.start, intervals.get(end).end);
            for(int k = 0; k <= end - start; k++)
                intervals.remove(start);
            intervals.add(start, res);
        }
        else if(end == -1) {
            end = 0;
            while(end < intervals.size() && newInterval.end > intervals.get(end).start)
                end++;
            Interval res = new Interval(intervals.get(start).start, newInterval.end);
            for(int k = 0; k < end - start; k++)
                intervals.remove(start);
            intervals.add(start, res);
        }
        else {
            Interval res = new Interval(intervals.get(start).start, intervals.get(end).end);
            for(int k = 0; k <= end - start; k++)
                intervals.remove(start);
            intervals.add(start, res);
        }
        return intervals;
    }

    public int findInterval(List<Interval> intervals, int num) {
        int res = -1;
        for(int i = 0; i < intervals.size() && res == -1; i++) {
            if(num >= intervals.get(i).start && num <= intervals.get(i).end)
                res = i;
        }
        return res;
    }
}
