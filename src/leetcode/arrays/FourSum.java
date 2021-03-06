//18. 4Sum

/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/

package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, -1, 0, -2, 2 };

		List<List<Integer>> res = new FourSum().new Solution().fourSum(nums, 0);

		System.out.println(Arrays.asList(res));

	}

	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {

			List<List<Integer>> res = new ArrayList<>();
			
			Arrays.sort(nums);

			for (int i = 0; i + 3 < nums.length; i++) {

				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				for (int j = 1; j + 2 < nums.length; j++) {

					if (j > 1 && nums[j] == nums[j - 1]) {
						continue;
					}
					int k = j + 1;
					int r = nums.length - 1;

			
					while (k < r) {

						if ((nums[i] + nums[j]+nums[k] + nums[r])== target) {
							res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[r]));
							k++;
							r--;
							while (k < r && nums[k] == nums[k - 1]) {
								k++;
							}
							while (k < r && nums[r] == nums[r + 1]) {
								r--;
							}
						} else if ((nums[i] + nums[j]+nums[k] + nums[r]) > target) {
							r--;

						} else {
							k++;
						}
					}

				}
			}

			return res;
		}
	}

}
