package leetcde.string;

public class IntegerToRoman {

	public static void main(String[] args) {

		int num =3467;
		String res = new IntegerToRoman().new Solution().intToRoman(num);
		System.out.println("Result is   "+ res);
		
		
	}

	class Solution {
		public String intToRoman(int num) {

			int[] numeric = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
			String res = "";
			for (int i = 0; i < str.length; i++) {
				int count = 0;
				if (num >= numeric[i]) {
					count = num / numeric[i];
					num = num % numeric[i];
				}
				for (int j = 0; j < count; j++) {
					res += str[i];
				}

			}
			return res;
		}
	}

}
