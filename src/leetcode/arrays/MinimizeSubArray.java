package leetcode.arrays;

public class MinimizeSubArray {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5};
		int res = new MinimizeSubArray().new Solution().minSubArrayLen(9, nums);
		int result = new MinimizeSubArray().new Solution().minSubArrayLength(9, nums);
		System.out.println("Result "+ res);
		System.out.println("Result "+ result);
		
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
		public int minSubArrayLength(int s, int[] a) {
			  if (a == null || a.length == 0)
			    return 0;
			  
			  int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
			  
			  while (j < a.length) {
			    sum += a[j];
			    j++;
			    
			    while (sum >= s) {
			      min = Math.min(min, j - i);
			      sum -= a[i];
			      i++;
			    }
			  }
			  
			  return min == Integer.MAX_VALUE ? 0 : min;
			}
	}
	
	
	
}
