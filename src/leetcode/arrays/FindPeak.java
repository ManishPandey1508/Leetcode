package leetcode.arrays;

public class FindPeak {

	public static void main(String[] args) {

		int[] nums = {10, 20, 15, 2, 23, 90, 67};
		int res = new FindPeak().new Solution().findPeakElement(nums);
		System.out.println("Result:"+ res);
	}

	class Solution {
		public int findPeakElement(int[] nums) {

			return findPeak(nums, 0, nums.length-1);
		}

		public int findPeak(int[] nums, int low, int high) {

			int mid = low + (high - low) / 2;

			if (mid == 0 && nums[mid] > nums[mid + 1]) {
				return nums[mid];
			}
			if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
				return nums[mid];
			} else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {

				return nums[mid];
			} else if (nums[mid] < nums[mid - 1]) {

				return findPeak(nums, low, mid - 1);

			} else {
				return findPeak(nums, mid + 1, high);

			}

		}

	}

}
