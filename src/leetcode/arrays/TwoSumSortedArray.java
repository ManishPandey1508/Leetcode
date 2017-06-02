/*167. Two Sum II - Input array is sorted

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

package leetcode.arrays;

import leetcode.utils.ArrayUtills;

public class TwoSumSortedArray {

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int[] result = new TwoSumSortedArray().new Solution().twoSum(numbers, 9);
		ArrayUtills.printArray(result);
	}

	class Solution {
		public int[] twoSum(int[] numbers, int target) {
			int low = 0;
			int high = numbers.length - 1;

			while (numbers[low] + numbers[high] != target) {
				if (numbers[low] + numbers[high] < target) {
					low++;
				} else {
					high--;
				}
			}
			return new int[] { low + 1, high + 1 };
		}
	}
}
