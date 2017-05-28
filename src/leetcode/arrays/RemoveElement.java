/*Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

*/

//To delete duplicates without using another array, idea is to sort the Array and than run loop and 
//compare adjacent element and remove duplicates 


package leetcode.arrays;


public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3,3,4,5,9,11,23};
		int val = 3;
		
		System.out.println("Length after removing Duplicates" + new RemoveElement().new Solution().removeElement(nums,val));

	}

	class Solution {

		public int removeElement(int[] nums, int val) {

			if(nums.length==0){
				System.out.println("Array is empty");
				return 0;
			}
			
			nums = quicksort(nums);
			int b = 0;
			for (int i = 0; i < nums.length; i++) {
				if(nums[b]!=nums[i]){
					b++;
					nums[b]=nums[i];
				}
			}
			return  b+1;
		}

		private int[] quicksort(final int[] nums) {
			quicksort(nums, 0, nums.length - 1);
			return nums;
		}

		private void quicksort(final int[] nums, final int low, final int high) {
			int i = low, j = high;
			int pivot = nums[low + (high - low) / 2];
			while (i <= j) {
				while (nums[i] < pivot) {
					i++;
				}
				while (nums[j] > pivot) {
					j--;
				}
				if (i <= j) {
					swap(nums, i, j);
					i++;
					j--;
				}
			}
			if (low < j) {
				quicksort(nums, low, j);
			}
			if (i < high) {
				quicksort(nums, i, high);
			}
		}

		private void swap(final int[] values, final int i, final int j) {
			final int temp = values[i];
			values[i] = values[j];
			values[j] = temp;
		}

	}

}
