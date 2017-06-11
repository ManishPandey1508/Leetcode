/*605. Can Place Flowers
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers 
cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.*/

package leetcode.arrays;

public class CanPlaceFlowers {

	public static void main(String[] args) {

		int[] flowerBed = { 1 };

		boolean res = new CanPlaceFlowers().new Solution().canPlaceFlowers(flowerBed, 0);
		System.out.println("result " + res);
	}

	class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			int count = 0;

			if (n == 0)
				return true;
			if ((flowerbed.length / 2) + 1 < n)
				return false;
			if (flowerbed.length == 1 && flowerbed[0] == 1)
				return false;
			if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)
				return true;

			for (int i = 0; i < flowerbed.length; i++) {

				// Handle index i = 0 condition
				if (i == 0) {
					if (flowerbed.length > 1 && flowerbed[i] != 1 && flowerbed[i + 1] != 1) {
						flowerbed[0] = 1;
						count += 1;
					}
				} else if (i == flowerbed.length - 1) {
					if (flowerbed[i - 1] != 1 && flowerbed[i] != 1) {
						flowerbed[i] = 1;
						count += 1;
					}
				} else {
					if (flowerbed[i] != 1 && flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
						flowerbed[i] = 1;
						count += 1;
					}
				}
			}

			if (count >= n)
				return true;
			else
				return false;

		}
	}

}
