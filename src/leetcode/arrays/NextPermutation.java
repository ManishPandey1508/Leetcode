/*31: Next Permutation
 * implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/
package leetcode.arrays;

import leetcode.utils.ArrayUtills;

public class NextPermutation {

	public static void main(String[] args) {
		
		int[] nums = {6,3,4,9,8,7,1};
		ArrayUtills.printArray(nums);
		new NextPermutation().new Solution().nextPermutation(nums);
		ArrayUtills.printArray(nums);
	}

	class Solution {

		public void swap(int[] nums, int i, int j) {

			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}

		public void reverse(int[] nums, int i, int j) {
			for (; i < j; i++, j--) {
				swap(nums, i, j);
			}

		}

		public void nextPermutation(int[] nums) {

			if (nums.length <= 1) {
				return;
			}
			
			int i = nums.length - 1;

			for (; i > 0; i--) {

				if (nums[i] > nums[i - 1]) {
					System.out.println("I is" + i);
					break;
				}
			}
			if (i != 0) {
				int x = nums.length - 1;
				for (; x >= i; x--) {

					if (nums[x] > nums[i-1]) {
						break;
					}
				}
				swap(nums, i-1, x);
			}

			reverse(nums, i, nums.length - 1);

			ArrayUtills.printArray(nums);

		}
	}

}
