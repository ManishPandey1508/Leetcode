package leetcde.string;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {
		
		
		int res = new RomanToInteger().new Solution().romanToInt("MMMCDLXVII");
		System.out.println("Result  "+ res);
	}

	class Solution {
		public int romanToInt(String s) {
			
			HashMap<Character,Integer> mapping = new HashMap<>();
			mapping.put('M', 1000);
			mapping.put('D', 500);
			mapping.put('C', 100);
			mapping.put('L', 50);
			mapping.put('X', 10);
			mapping.put('V', 5);
			mapping.put('I', 1);
			
			int res = 0;
			int n = s.length();
			if (s == null || n == 0)
				return 0;

			for (int i = 0; i < n; i++) {
				
				if(i!=n-1 && mapping.get(s.charAt(i))< mapping.get(s.charAt(i+1)))
					res-=mapping.get(s.charAt(i));
				else
					res+= mapping.get(s.charAt(i));
			}
			return res;
		}
	}
}
