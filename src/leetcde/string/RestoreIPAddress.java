package leetcde.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public static void main(String[] args) {
	
		String s = "0000";
		
		List<String> res = new RestoreIPAddress().new Solution().restoreIpAddresses(s);
		System.out.println("Result  "+ res);

	}

	class Solution {
		public List<String> restoreIpAddresses(String s) {

			ArrayList<String> res = new ArrayList<>();
			int len = s.length();

			for (int i = 1; i < 4 && i < len - 2; i++) {

				for (int j = i + 1; j < 4 + i && j < len - 1; j++) {

					for (int k = j + 1; k < 4 + j && k < len; k++) {

						String s1 = s.substring(0, i);
						String s2 = s.substring(i, j);
						String s3 = s.substring(j, k);
						String s4 = s.substring(k, len);

						if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {

							res.add(s1 + "." + s2 + "." + s3 + "." + s4);

						}

					}
				}

			}
			return res;

		}

		public boolean isValid(String s) {

			if (s.length() == 0 || s.length() > 3 || Integer.parseInt(s) > 255
					|| (s.charAt(0)=='0' && s.length() > 1)) {
				return false;
			} else
				return true;
		}

	}

}
