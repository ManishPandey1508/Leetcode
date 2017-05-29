/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.*/

//53. Maximum Subarray
package leetcode.arrays;

public class MaxSubarray {

	public static void main(String[] args) {
	
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Sum of the Maximum Subarray is : "+ new MaxSubarray().new Solution().maxSubArray(nums) );

	}

	class Solution {
		public int maxSubArray(int[] nums) {
			
			int max_current = nums[0];
			int max_global = nums[0];
			
			for (int i = 1; i < nums.length; i++) {
				
				max_current = Math.max(nums[i],max_current+nums[i]);
				max_global = Math.max(max_current, max_global);
				
			}
			
			return max_global;
		}
	}

}
