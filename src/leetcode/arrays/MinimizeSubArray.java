package leetcode.arrays;

public class MinimizeSubArray {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5};
		int res = new MinimizeSubArray().new Solution().minSubArrayLen(11, nums);
		System.out.println("Result "+ res);
		
	}

	class Solution {
		public int minSubArrayLen(int s, int[] nums) {
			if(nums.length==0)
				return -1;
			
			int min = 0;
			for (int i = 0; i < nums.length; i++) {
				int j = i;
				int sum = 0;
				while (j < nums.length && sum < s) {
					sum += nums[j];
					if (sum >= s) {
						if(min==0)
						min = j - i+1;
						else
						min = Math.min(j - i+1, min);
						break;
					}
					j++;
				}
				
			}

			return min;

		}
	}
}
