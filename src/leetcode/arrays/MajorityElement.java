 
/*169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears 
more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
[3,3,3,4,5,6,3] --->> 3
*/
package leetcode.arrays;

public class MajorityElement {

	public static void main(String[] args) {

		int[] nums = {4,3,3,3,4,5,6,3,4,3,5,3,3};
		int major = new MajorityElement().new Solution().majorityElement(nums);
System.out.println("Majority Element is : " + major);
	}

	class Solution {
		public int majorityElement(int[] nums) {
			int count = 1;
			int major = nums[0];
		
			for (int i = 1; i < nums.length; i++) {
				
				if(count ==0){
					count++;
					major = nums[i];
				}
				else if(major == nums[i]){
					count++;
				}
				else{
					count--;
				}
				
			}
		return major;
		
		}
	}
}
