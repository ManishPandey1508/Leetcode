package leetcde.string;

public class LongestPalindrome {

	public static void main(String[] args) {

		String s = "banana";
		String res = new LongestPalindrome().new Solution().longestPalindrome(s);
		String resnew = new LongestPalindrome().new Solution().LPS(s);
		System.out.println("result  " + res);
		System.out.println("result  " + resnew);
	}

	class Solution {
		public String longestPalindrome(String s) {

			int n = s.length();
			if (n == 1)
				return s;
			int max = 0;
			String maxString = "";

			for (int i = 0; i < n; i++) {

				for (int j = n - 1; j > i; j--) {
					if (s.charAt(i) == s.charAt(j)) {
						int k = i;
						int l = j;
						while (k < l) {
							if (s.charAt(k) == s.charAt(l)) {
								k++;
								l--;
							} else {
								break;
							}
						}
						if (k >= l && max < j - i + 1) {

							max = j - i + 1;
							maxString = s.substring(i, j + 1);
						}
					}
				}
				if (max == 0) {
					maxString = s.charAt(0) + "";
				}

			}
			return maxString;
		}

		public String LPS(String s) {
			  int n = s.length();
			  int palindromeBeginsAt = 0; //index where the longest palindrome begins
			  int max_len = 1;//length of the longest palindrome
			  boolean palindrome[][] = new boolean[n][n]; //boolean table to store palindrome truth
			  
			  //Trivial case: single letter palindromes
			  for (int i = 0; i < n; i++) {
				  palindrome[i][i] = true;
			  }
			  
			  //Finding palindromes of two characters.
			  for (int i = 0; i < n-1; i++) {
			    if (s.charAt(i) == s.charAt(i+1)) {
			      palindrome[i][i+1] = true;
			      palindromeBeginsAt = i;
			      max_len = 2;
			    }
			  }
			  
			  //Finding palindromes of length 3 to n and saving the longest
			  for (int curr_len = 3; curr_len <= n; curr_len++) {
			    for (int i = 0; i < n-curr_len+1; i++) {
			      int j = i+curr_len-1;
			      if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
			    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
			      {
			    	palindrome[i][j] = true; 
			        palindromeBeginsAt = i;
			        max_len = curr_len;
			      }
			    }
			  }
			  return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
			}

		
		
		
	}
}
