/*55. Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

package leetcode.arrays;

public class JumpGame {

	public static void main(String[] args) {
		
		int[] A = {3,2,1,0,4};
		
		boolean isReachable = new JumpGame().new Solution().canJump(A);
		System.out.println("Is Last Index Reachable :  "+ isReachable);
		
	}

	class Solution {
		public boolean canJump(int[] nums) {
			int maxJump = nums[0];

			for (int i = 0; i < nums.length; i++) {

				if (maxJump < i)
					return false;

				maxJump = maxJump > i + nums[i] ? maxJump : i + nums[i];

			}

			return true;
		}
	}
}
