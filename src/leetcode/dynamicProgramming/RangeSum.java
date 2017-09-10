package leetcode.dynamicProgramming;

public class RangeSum {

	public static void main(String[] args) {

		RangeSum rangeSum = new RangeSum();
		NumArray nums = new RangeSum().new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		int res = nums.sumRange(2, 5);
		System.out.println("Result " + res);
	}

	class NumArray {

		int[] sums;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			sums = new int[nums.length];
			sums[0] = nums[0];

			for (int i = 1; i < nums.length; i++) {
				sums[i] = sums[i - 1] + nums[i];
			}

		}

		public int sumRange(int i, int j) {
			if (sums != null)
				return i == 0 ? sums[j] : sums[j] - sums[i - 1];
			else
				return 0;

		}
	}
}
