/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being
1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/
package leetcode.arrays;

public class RemoveDuplicatesTwo {

	public static void main(String[] args) {
		 int[] nums = {1,1,1,2,2,3};
		//int[] nums = { 1, 2, 2 };

		System.out.println(
				"Length after removing Duplicates" + new RemoveDuplicatesTwo().new Solution().removeDuplicates(nums));

	}

	class Solution {
		public int removeDuplicates(int[] nums) {
			int n = nums.length;
			if (n <= 2)
				return n;

			int i = 1, j = 1;
			int cnt = 1;
			while (j < n) {
				if (nums[j] != nums[j - 1]) {
					cnt = 1;
					nums[i++] = nums[j];
				} else {
					if (cnt < 2) {
						nums[i++] = nums[j];
						cnt++;
					}
				}
				++j;
			}
			return i;
		}
	}
}
