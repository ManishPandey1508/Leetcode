package leetcde.string;

public class LengthOfLastWord {

	public static void main(String[] args) {

		String s = "dkbfkbfjkw";
		int res = new LengthOfLastWord().new Solution().lengthOfLastWord(s);

		int result = new LengthOfLastWord().new Solution().lengthOfLastWord2(s);
		System.out.println("Result " + res);
		System.out.println("Result " + result);

	}

	class Solution {
			public int lengthOfLastWord(String s) {
				if (s == null || s.length() == 0)
					return 0;
				
				int last= s.length()-1;
				while(last>0 && s.charAt(last)==' ')
					last--;
				s = s.substring(0, last+1);
				
				int slow = -1, fast = 0;
	
				char[] strs = s.toCharArray();
	
				for (fast = 0; fast < strs.length; fast++) {
	
					if (strs[fast] == ' ')
						slow = fast;
	
				}
				return fast - (slow+1);
			}
			
			public int lengthOfLastWord2(String s){

				if (s == null || s.length() == 0)
					return 0;
				
				int last= s.length()-1;
				int len =0;
				while(last>=0 && (s.charAt(last)==' '))
					last--;
				while(last>=0 && !(s.charAt(last)==' '))
				{	last--;
				len++;
				}
				
				
				return len;
			
				
			}

	}
}