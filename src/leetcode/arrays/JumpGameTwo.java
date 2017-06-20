/*45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.*/

package leetcode.arrays;

public class JumpGameTwo {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 1, 1, 4 };
		int noOfSteps = new JumpGameTwo().new Solution().jump(nums);
		System.out.println("No of Steps" + noOfSteps);
		int arr[] = {  2, 1, 1, 1, 4};
		int r[] = new int[arr.length];
		int result = new JumpGameTwo().new Solution().minJump(arr, r);
		System.out.println(result);

	}

	class Solution {
		public int jump(int[] nums) {

			int minSteps = 0;// Minimum steps for reaching e
			int longestDistPossible = 0; // longest distance possible from
											// current index
			int Max = 0;// current max

			for (int i = 0; i < nums.length - 1; i++) {

				Max = Math.max(Max, i + nums[i]);

				if (i == longestDistPossible) {

					minSteps++;
					longestDistPossible = Max;

				}

			}
			return minSteps;

		}

		public int minJump(int arr[], int result[]) {

			int[] jump = new int[arr.length];
			jump[0] = 0;
			for (int i = 1; i < arr.length; i++) {
				jump[i] = Integer.MAX_VALUE - 1;
			}

			for (int i = 1; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[j] + j >= i) {
						if (jump[i] > jump[j] + 1) {
							result[i] = j;
							jump[i] = jump[j] + 1;
						}
					}
				}
			}
			return jump[jump.length - 1];
		}

	}
}
