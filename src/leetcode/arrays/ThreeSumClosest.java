/*16. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

	*/

package leetcode.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { 1,1,-1,-1,3};

		int res = new ThreeSumClosest().new Solution().threeSumClosest(nums, -1);

		System.out.println(res);
	}

	class Solution {
		public int threeSumClosest(int[] nums, int target) {
			
			if(nums.length<3)
			{
				int sum = 0 ;
				for (int i = 0; i < nums.length; i++) {
					sum = sum+nums[i];
				}
				return sum;
			}
			
			Arrays.sort(nums);
			int result = nums[0] + nums[1] + nums[2];
			
			for (int i = 0; i  < nums.length -2; i++) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					System.out.println("Sum"+sum);
					if (Math.abs(target - sum) < Math.abs(target - result))
						result = sum;
					if (sum > target)
						k--;
					else
						j++;
				}		
			}
			return result;
		}

	}
}
