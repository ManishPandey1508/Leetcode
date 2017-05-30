/*15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
	*/	

package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-2,0,1,1,2};
		
		List<List<Integer>> res = new ThreeSum().new Solution().threeSum(nums);
		
		  System.out.println(Arrays.asList(res));


	}

	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {

			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);

			for (int i = 0; i + 2 < nums.length; i++) {

				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int j = i + 1;
				int k = nums.length - 1;
				int target = -nums[i];
				while (j < k) {
					if (nums[j] + nums[k] == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[k]));

						j++;
						k--;

						while (j < k && nums[j] == nums[j-1]) {
							j++;
						}
						while (j < k && nums[k] == nums[k+1]) {
							k--;
						}
					} 
					else if (nums[j] + nums[k] > target)
						k--;
					else
						j++;

				}	
			}
			return res;

		}
	}

}
