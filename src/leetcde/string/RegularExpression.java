/*Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
package leetcde.string;

public class RegularExpression {

	public static void main(String[] args) {

		String s = "aa";
		String p = "a*";
		boolean res = new RegularExpression().new Solution().isMatch(s, p);
		
		System.out.println("Result "+ res);
		
	}

	class Solution {
		public boolean isMatch(String s, String p) {

			if (s == null || p == null)
				return false;

			int n = s.length();
			int m = p.length();

			boolean[][] dp = new boolean[n + 1][m + 1];
			dp[0][0] = true;
			// To handle pattern like a*b*c*... these pattern even return true
			// with empty string;

			 for (int i = 0; i < p.length(); i++) {
			        if (p.charAt(i) == '*' && dp[0][i-1]) {
			            dp[0][i+1] = true;
			        }
			    }
			 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(s.charAt(i)==p.charAt(j) || (p.charAt(j)=='.')){
						dp[i+1][j+1]= dp[i][j];
					}
					if(p.charAt(j)=='*')
					{
						if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.'){
							dp[i+1][j+1]= dp[i+1][j-1];
						}
						else{
							dp[i+1][j+1] = dp[i][j+1]|| dp[i+1][j] || dp[i+1][j-1];
						}
						
					}
					
				}

			}
			 return dp[n][m];
		}
	}
}
