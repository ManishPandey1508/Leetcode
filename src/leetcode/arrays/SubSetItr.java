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
import java.util.List;

public class SubSetItr {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		List<List<Integer>> res = new SubSetItr().new Solution().subsets(arr);
		System.out.println(res);
	}

	class Solution {
		public List<List<Integer>> subsets(int[] nums) {

			List<List<Integer>> result = new ArrayList<>();
			// Added Blank List
			result.add(new ArrayList<Integer>());

			for (int i = 0; i < nums.length; i++) {
				List<List<Integer>> temp = new ArrayList<>();

				for (List<Integer> a : result) {

					temp.add(new ArrayList<Integer>(a));
				}

				for (List<Integer> s : temp) {
					s.add(nums[i]);
				}
				
				result.addAll(temp);
			}

			return result;
		}
	}
}
