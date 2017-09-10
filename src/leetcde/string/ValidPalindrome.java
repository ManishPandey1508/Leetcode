/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
package leetcde.string;

public class ValidPalindrome {

	public static void main(String[] args) {

		String s= "            45435345436   ~###~&^&^% ";
		boolean res = new ValidPalindrome().new Solution().isPalindrome(s);
		
		System.out.println("Result   "+ res);
		
		
	}

	class Solution {
		public boolean isPalindrome(String s) {

			if (s.length() == 0)
				return true;

			String snew = s.replaceAll("[^A-Za-z0-9]", "");

			int low = 0;
			int high = snew.length()-1;
			boolean isPalindrome = true;

			if (snew.length() == 0)
				return true;
			snew= snew.toLowerCase();
			
			while (low < high) {
				if (snew.charAt(low) != snew.charAt(high)) {
					isPalindrome = false;
					break;
				}
				low++;
				high--;
			}
			return isPalindrome;
		}
	}

}
