/*
 * 485. Max Consecutive Ones
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/
package leetcode.arrays;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		//int[] nums = { 1, 1, 0, 1, 1, 1,0,0,1,1,1,1,1,1,0,0,1,0,1,0 };
		int[] nums = {0};

		int res = new MaxConsecutiveOnes().new Solution().findMaxConsecutiveOnes(nums);

		System.out.println("Max One's " + res);
	}

	class Solution {
		public int findMaxConsecutiveOnes(int[] nums) {

			int max = 0;
			int temp = 0;
			boolean oneStart = false;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 1 && oneStart == false) {
					oneStart = true;
					temp += 1;
					if (temp > max)
						max = temp;
				} else if (nums[i] == 1 && oneStart == true) {
					temp += 1;
					if (temp > max)
						max = temp;
				} else if (nums[i] == 0 && oneStart == true) {
					oneStart = false;
					if (temp > max)
						max = temp;
					temp = 0;
				}
			}
			return max;
		}
	}

}
