/*Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetTwo {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 2, 3 };
		
		List<ArrayList<Integer>> res = new SubsetTwo().new Solution().subsets(arr);
		System.out.println(res);
	}

	class Solution {
		public ArrayList<ArrayList<Integer>> subsets(int[] num) {
			if (num == null)
				return null;

			Arrays.sort(num);

			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
			// add empty set
			result.add(new ArrayList<Integer>());

			for (int i = 0; i < num.length; i++) {
				// get existing sets 
				if (i == 0 || num[i] != num[i - 1]) {// This condition is extra form Sub Sets 1 
					prev = new ArrayList<ArrayList<Integer>>();
					for (int j = 0; j < result.size(); j++) {
						prev.add(new ArrayList<Integer>(result.get(j)));
					}
				}

				// add current number to each element of the set
				for (ArrayList<Integer> temp : prev) {
					temp.add(num[i]);
				}

				// add all set created in this iteration
				for (ArrayList<Integer> temp : prev) {
					result.add(new ArrayList<Integer>(temp));
				}
			}
			return result;
		}
	}
}
