
/*189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

package leetcode.arrays;

import leetcode.utils.ArrayUtills;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 7, k = 3;

		new ReverseArray().new Solution().rotate(nums, k);

	}

	class Solution {
		public void rotate(int[] nums, int k) {

			if (nums == null || nums.length < 2) {
				return;
			}

			k = k % nums.length;

			ArrayUtills.printArray(nums);
			reverse(nums, 0, nums.length - k - 1);
			reverse(nums, nums.length - k, nums.length - 1);
			reverse(nums, 0, nums.length - 1);
			ArrayUtills.printArray(nums);

		}

		public void reverse(int[] nums, int j, int k) {

			while (j < k) {
				int temp = nums[j];
				nums[j] = nums[k];
				nums[k] = temp;
				j++;
				k--;

			}

		}

	}
}
