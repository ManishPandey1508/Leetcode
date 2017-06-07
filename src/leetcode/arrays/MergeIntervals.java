/*56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/
package leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public class Interval {
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
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{"+start+","+end+"}";
		}
	}

	public static void main(String[] args) {

		
		List<Interval> intervals = new ArrayList<Interval>();
		MergeIntervals mergeIntervals = new MergeIntervals();
		intervals.add(mergeIntervals.new Interval(1,3));
		intervals.add(mergeIntervals.new Interval(2,6));
		intervals.add(mergeIntervals.new Interval(8,10));
		intervals.add(mergeIntervals.new Interval(15,18));
		
		intervals =new MergeIntervals().new Solution().merge(intervals);
		
		System.out.println(intervals);
		
	}

	class Solution {
		public List<Interval> merge(List<Interval> intervals) {

			if (intervals.size() == 0)
				return intervals;
			// Sort the Intervals List on the basis of start point
			// Using Lambda Comporator in Java 8
			intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

			int start = intervals.get(0).start;
			int end = intervals.get(0).end;
			List<Interval> result = new LinkedList<Interval>();

			for (Interval interval : intervals) {

				if (interval.start <= end) {
					end = Math.max(end, interval.end);

				} else {
					result.add(new Interval(start, end));
					start = interval.start;
					end = interval.end;

				}

			}result.add(new Interval(start,end));
			
			return result;
		}

	}
}
