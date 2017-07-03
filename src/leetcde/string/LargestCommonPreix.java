package leetcde.string;

public class LargestCommonPreix {

	public static void main(String[] args) {
		
		String[]strs = {"b","","b"};
		String res = new LargestCommonPreix().new Solution().longestCommonPrefix(strs);
		System.out.println("Result  "+ res);
	}

	class Solution {
		public String longestCommonPrefix(String[] strs) {

			if (strs == null || strs.length == 0)
				return "";
			if(strs.length==1)
				return strs[0];
			
			String prefixMatched = strs[0];

			for (int i = 0; i < strs.length; i++) {
				int j = 0;
				if(strs[i].length()==0){
					prefixMatched = "";
					break;
				}
			int min = Math.min(strs[i].length(), prefixMatched.length());
				while (j<min && strs[i].charAt(j) == prefixMatched.charAt(j))
					j++;
				
				 if(j<prefixMatched.length())
					prefixMatched=prefixMatched.substring(0, j);

				

			}
			return prefixMatched;

		}
	}
}
