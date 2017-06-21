package leetcode.arrays;

public class FindMinRotatedArray {

	public static void main(String[] args) {
		int nums[] = {4 ,5,6, 7, 0, 1, 2};
		
		int res = new FindMinRotatedArray().new Solution().findMin(nums);
		
		System.out.println("Min element"+ res);

	}

	class Solution {
		public int findMin(int[] nums) {

			if (nums.length == 0)
				return 0;
			if (nums.length == 1)
				return nums[0];

			int start = 0, mid = 0, end = nums.length - 1;
			while (start < end) {

				mid = start + (end - start) / 2;

				if (mid > 0 && nums[mid] < nums[mid - 1]) {
					return nums[mid];
				} else if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {

					start = mid + 1;

				} else {
					end = mid - 1;
				}

			}
			return nums[start];
		}
	}
}
