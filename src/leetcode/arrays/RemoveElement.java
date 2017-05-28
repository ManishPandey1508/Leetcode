/*Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

*/

// Since all instance of element has to be removed no need of sorting, 
//just scan all over the array keep one slow pointer and remove the val.

package leetcode.arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;

		System.out.println(
				"Length after removing Duplicates" + new RemoveElement().new Solution().removeElement(nums, val));

	}

	class Solution {

		public int removeElement(int[] nums, int val) {

			if (nums.length == 0) {
				System.out.println("Array is empty");
				return 0;
			}

			int n = nums.length;
			int i = 0;
			while (i < n) {
				if (nums[i] == val) {
					nums[i] = nums[n - 1];
					n--;
				}
				else{
				i++;
				}
			}	
			return n;
		}

	}

}
