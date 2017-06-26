package leetcode.arrays;

/*Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order*/
public class FindUnsortedSubArray {

	public static void main(String[] args) {
		int[] nums={1,2,3,4};
		int res = new FindUnsortedSubArray().new Solution().findUnsortedSubarray(nums);
		System.out.println("Result "+ res);
	}

	class Solution {
		public int findUnsortedSubarray(int[] nums) {
			int n = nums.length;
			int min = nums[n - 1];
			int max = nums[0];
			int beg = -1;
			int end = -2;

			for (int i = 1; i < nums.length; i++) {

				min = Math.min(min, nums[n - 1 - i]);
				max = Math.max(max, nums[i]);
				if (nums[i] < max)
					end = i;
				if (nums[n - 1 - i] > min)
					beg = n - 1 - i;

			}
			return end-beg +1;
		}
	}
}
