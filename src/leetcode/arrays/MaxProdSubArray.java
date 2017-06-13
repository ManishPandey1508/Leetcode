/*152. Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
package leetcode.arrays;

public class MaxProdSubArray {

	public static void main(String[] args) {

		int[] nums = {-2, -3, 0, -2, -40};
		 int res = new MaxProdSubArray().new Solution().maxProduct(nums);
		 System.out.println("Result "+ res );
		
	}

	class Solution {
		public int maxProduct(int[] nums) {

			if(nums.length == 0)return 0;
			
			int maxProduct = nums[0];
			int minProduct = nums[0];
			int maxRes = nums[0];

			for (int i = 1; i < nums.length; i++) {

				if (nums[i] >= 0) {
					
					maxProduct = Math.max(maxProduct*nums[i], nums[i]);
					minProduct = Math.min(minProduct * nums[i], nums[i]);

				} else {
						int temp = maxProduct;
					maxProduct = Math.max(minProduct * nums[i], nums[i]);
					minProduct = Math.min(temp * nums[i],nums[i]);
				}
				maxRes = Math.max(maxProduct, maxRes);

			}
			return maxRes;
		}
	}

}
