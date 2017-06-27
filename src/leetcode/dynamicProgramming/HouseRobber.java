/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
*/

package leetcode.dynamicProgramming;

public class HouseRobber {

	public static void main(String[] args) {
		
		int nums[] = {5,2,1,35,32,45,15};
		int res = new HouseRobber().new Solution().rob(nums);
		System.out.println("Result "+ res);
		
	}

	class Solution {
	    public int rob(int[] nums) {
	        int rob = 0;// Value if current house is robbed
	    	int notRob= 0;//// Value if current house is not robbed
	    	
	    	for (int i = 0; i < nums.length; i++) {
				
	    		int currentROb = notRob + nums[i];
	    		notRob = Math.max(rob, notRob);
	    		rob = currentROb;
			}
	    	return Math.max(rob, notRob);
	    	
	    }
	}
}
