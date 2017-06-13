/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

*/
package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

	public static void main(String[] args) {
		int[] nums = {2,1,4,5,6,7,3,2,8};
	List<Integer> res = new FindAllDuplicates().new Solution().findDuplicates(nums);
	System.out.println(res.toString());
	}

	class Solution {
		public List<Integer> findDuplicates(int[] nums) {

			List<Integer> res =new ArrayList<>();
			
			for (int i = 0; i < nums.length; i++) {

				int m = Math.abs(nums[i]);
				if(nums[m-1]<0){
					res.add(Math.abs(nums[i]));
				}else
					nums[m-1] = -nums[m-1];
				}
			
			return res;
		}
	}
}
